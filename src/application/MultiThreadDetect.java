package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MultiThreadDetect implements Runnable{
	Robot robot ;
	imgProcess task;
	FindColor findcolor;
	public boolean exit;
	MainController controller;
	
	public MultiThreadDetect(MainController controller) throws IOException 
	{
		exit = true;
		this.controller = controller;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while(exit)
		{
			
			task = new imgProcess();
			
			int number = task.findNumber();
			
			if(controller != null)
			{
				Platform.runLater(()->{
					controller.setLabelNumber(number);
					controller.addlvNumber(number);
				});

				
			}
			
			if( number >=0 && number <= 9)
			{
				while(controller.isAction)
				{
					robot.delay(2000);
				}
				Platform.runLater(()->{
					controller.isAction = true;
				});
				controller.isAction = true;
				robot.keyPress(number + 48);
				robot.delay(50);
				robot.keyRelease(number + 48);
				
				Platform.runLater(()->{
					controller.isAction = false;
				});
				System.out.println("±¾¾÷°»´ú : «ö¤F«öÁä"+number);
				
			}
			findcolor = new FindColor();
			findcolor.determineLocation();
			while(exit && !findcolor.isFind())
			{
				findcolor.changeImage();
				findcolor.determineLocation();
				if(!findcolor.isFind())
					Platform.runLater(()->{
							controller.setX("x");
					});
			}
			Platform.runLater(()->{
				if(findcolor.isFind())
					controller.setX("("+findcolor.location[0]+","+findcolor.location[1]+")");
//				robot.mouseMove(findcolor.location[0], findcolor.location[1]-findcolor.distance);
				
//				controller.setX(""+findcolor.distance);
			});
			
//			if(findcolor.findEmoji())
//			{
//				while(controller.isAction)
//				{
//					robot.delay(2000);
//				}
//				Platform.runLater(()->{
////					controller.addlvDisease(true);
//					controller.isAction = true;
//				});
//				try {
////					robot.mouseMove(findcolor.a[0], findcolor.a[1]);
//					MultiThreadTimer.doTakeMedicine();					
//				} catch (AWTException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					System.out.println("afvad");
//				}
//				Platform.runLater(()->{
//					controller.isAction = false;
//				});
//			}
			
			//1 ¸z­Gª¢
			//2 µo¿N
			//3 ²©½H
			//4 ·P«_
			if(findcolor.isFind())
			{
				int emoji = findcolor.cvFindEmoji();
				if(emoji == 1)
				{
					Platform.runLater(() -> {
						controller.addlvDisease("¸z­Gª¢");
					});
				}
				else if(emoji == 2)
				{
					Platform.runLater(()->{
						controller.addlvDisease("µo¿N");
					});	
				}
				else if(emoji == 3)
				{
					Platform.runLater(()->{
						controller.addlvDisease("²©½H");
					});
				}
				else if(emoji == 4)
				{
					Platform.runLater(()->{
						controller.addlvDisease("·P«_");
					});
				}
				else
				{
					System.out.println("emoji ¨S§ä¨ì");
				}
			}
			findcolor = null;

			
			
		}
		System.out.println("°»´ú°±¤î");
		Platform.runLater(()->{
			controller.setX("ERROR");
		});
	}
	

	
	
	

}
