package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.format.DateTimeFormatter;

import javafx.application.Platform;

public class MultiThreadTimer implements Runnable{
	Robot robot;
	
	MainController controller;
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm:ss");
	public MultiThreadTimer(MainController controller)
	{
		this.controller = controller;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			robot = new Robot();
			Time timer = new Time(80,0); //70 minute
			while(!timer.getCurrentTime().equals("00:00"))
			{				
//				System.out.println(timer.getCurrentTime());
				Platform.runLater(()->{
					controller.setTime(timer.getCurrentTime());
				});
				Thread.sleep(1000);
			
				timer.oneSecondPassed();
			}
			while(controller.isAction)
			{
				robot.delay(2000);
			}
			Platform.runLater(()->{
				controller.isAction = true;
			});
			doDrinkandEat();
			Platform.runLater(()->{
				controller.isAction = false;
			});
			
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("AAAFFF");
			Thread.currentThread().interrupt();
		}
		catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public static void doDrinkandEat() throws AWTException, InterruptedException
	{
		Robot r = new Robot();
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_F2); // 1
		r.delay(30);
		r.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_F2); // 2
		r.delay(30);
		r.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r = null;
	}
	public static void doTakeMedicine() throws AWTException
	{
		Robot r = new Robot();
		
		r.delay(1000);
		try {
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_F2); // µo¿N
			r.delay(30);
			r.keyRelease(KeyEvent.VK_F2);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_UP);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_UP);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_F2); // ·P«_
			r.delay(30);
			r.keyRelease(KeyEvent.VK_F2);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_UP);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_UP);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_F2); // ²©½H
			r.delay(30);
			r.keyRelease(KeyEvent.VK_F2);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_UP);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_UP);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_F2); // ¸z­Gª¢
			r.delay(30);
			r.keyRelease(KeyEvent.VK_F2);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_UP);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_UP);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(30);
			r.keyRelease(KeyEvent.VK_ENTER);
			r = null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("hihihihi");
		
		}
	}	
//	public static void doDrinkandEat() throws AWTException
//	{
//		Robot r = new Robot();
//		r.delay(1000);
//		r.keyPress(KeyEvent.VK_F2); // 1
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_F2);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		
//		
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_F2); // 2
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_F2);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r = null;
//	}
//	public static void doTakeMedicine() throws AWTException
//	{
//		Robot r = new Robot();
//		
//		r.delay(1000);
//		r.keyPress(KeyEvent.VK_F2); // µo¿N
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_F2);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_UP);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_UP);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		
//		
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_F2); // ·P«_
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_F2);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_UP);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_UP);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		
//		
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_F2); // ²©½H
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_F2);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_UP);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_UP);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		
//		
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_F2); // ¸z­Gª¢
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_F2);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_UP);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_UP);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.delay(30);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		r = null;
//	}

}
