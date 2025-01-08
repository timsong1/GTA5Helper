package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javafx.application.Platform;

public class MultiThreadAction implements Runnable{
	
	int type;
	private static final Object LOCK = new Object();
	private static volatile boolean noLock = true;
	Robot r;
	imgProcess task;
	FindColor findcolor;
	
	MainController controller;
	
	
	public MultiThreadAction(int type,MainController controller) // 1 : �p�ɾ�  2 : ����  3 : �ͯf
	{
		this.type = type;
		this.controller = controller;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noLock = true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(type == 1)
			{			
				Time timer = new Time(80,0); //80 minute
				while(!timer.getCurrentTime().equals("00:00"))
				{				
//					System.out.println(timer.getCurrentTime());
					Platform.runLater(()->{
						controller.setTime(timer.getCurrentTime());
					});
					Thread.sleep(1000);
				
					timer.oneSecondPassed();
				}

				synchronized (LOCK) {
					
					if(noLock)
					{
						noLock = false;
//						Platform.runLater(()->{
//							controller.addlvDisease("�ɶ�");
//						});
//						Thread.sleep(10000);
						doDrinkandEat();
						noLock = true;
						LOCK.notifyAll();
					}
					else
					{
						LOCK.wait();
						System.out.println(type + "���b����");
					}
				}
				
	
			}
			else if(type ==2)
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
					synchronized (LOCK) {
						if(noLock)
						{
							System.out.println("�������� : ���F����"+number);
							noLock = false;
							r.keyPress(number + 48);
							Thread.sleep(50);
							r.keyRelease(number + 48);
							Thread.sleep(1000);
							r.keyPress(number + 48);
							Thread.sleep(50);
							r.keyRelease(number + 48);
//							Platform.runLater(()->{
//								controller.addlvDisease("����");
//							});
//							Thread.sleep(10000);
							noLock = true;
							LOCK.notifyAll();
						}
						else
						{
							LOCK.wait();
							System.out.println(type + "���b����");
						}
					}			
				}
			}
			else if(type ==3)
			{
				
				findcolor = new FindColor();
				
				findcolor.CVdetermineLocation();
//				while(!findcolor.isFind())
//				{
//					findcolor.changeSmallImage();
//					findcolor.determineLocation();
//					if(!findcolor.isFind())
//						Platform.runLater(()->{
//								controller.setX("x");
//						});
//					Thread.sleep(800);
//				}
				while(!findcolor.isFind())
				{
					findcolor.changeSmallImage();
					findcolor.CVdetermineLocation();
					if(!findcolor.isFind())
						Platform.runLater(()->{
								controller.setX("x");
						});
					System.out.println(type + "�S����Ŧ⪺�F�F");
					Thread.sleep(500);
				}
				if(findcolor.isFind())
				{
					System.out.print(findcolor==null);
					System.out.println(" �S���");
				}
				
				if(findcolor != null)
				{	
					if(findcolor.isFind())
						System.out.println("("+findcolor.location[0]+","+findcolor.location[1]+")");
						int x = findcolor.location[0];
						int y = findcolor.location[1];
						Platform.runLater(()->{
							controller.setX("("+x+","+y+")");
						});		
				}
				else
				{
						System.out.println("findcolor �� null : multithreadAction");
						Platform.runLater(()->{
							controller.setX("x");
						});		
				}

				//1 �z�G��
				//2 �o�N
				//3 ���H
				//4 �P�_
				if(findcolor.isFind())
				{
					int emoji = findcolor.cvFindEmoji();
					if(emoji == 1)
					{
						Platform.runLater(() -> {
							controller.addlvDisease("�z�G��");
						});
						synchronized (LOCK) {
							if(noLock)
							{
								noLock = false;

								doVomiting();
								doThermoment();
								noLock = true;
								LOCK.notifyAll();
							}
							else
							{
								LOCK.wait();
								System.out.println(type + "���b����");
							}
						}			
					}
					else if(emoji == 2)
					{
						Platform.runLater(()->{
							controller.addlvDisease("�o�N");
						});	
						synchronized (LOCK) {
							if(noLock)
							{
								noLock = false;
//								Platform.runLater(()->{
//									controller.addlvDisease("�ͯf . �o�N");
//								});
//								Thread.sleep(10000);
								doThermoment();
								noLock = true;
								LOCK.notifyAll();
							}
							else
							{
								LOCK.wait();
								System.out.println(type + "���b����");
							}
						}			
					}
					else if(emoji == 3)
					{
						Platform.runLater(()->{
							controller.addlvDisease("���H");
						});
						synchronized (LOCK) {
							if(noLock)
							{
								noLock = false;
//								Platform.runLater(()->{
//									controller.addlvDisease("�ͯf . ���H");
//								});
//								Thread.sleep(10000);
								doScream();
								doThermoment();
								noLock = true;
								LOCK.notifyAll();
							}
							else
							{
								LOCK.wait();
								System.out.println(type + "���b����");
							}
						}		
					}
					else if(emoji == 4)
					{
						Platform.runLater(()->{
							controller.addlvDisease("�P�_");
						});
						synchronized (LOCK) {
							if(noLock)
							{
								noLock = false;
//								Platform.runLater(()->{
//									controller.addlvDisease("�ͯf . �P�_");
//								});
//								Thread.sleep(10000);
								doMask();
								doThermoment();
								noLock = true;

								
								
								LOCK.notifyAll();
							}
							else
							{
								LOCK.wait();
								System.out.println(type + "���b����");
							}
						}		
					}
					else
					{
						System.out.println("emoji �S���");
					}
				}
				findcolor = null;
			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("����� type : "+type+" ����");
			Thread.currentThread().interrupt();
		}catch(Exception e2)
		{
			System.out.println("��������`����");
		}
		
		System.out.println("����� type : "+type+" ���� ....");
	}
	public void doDrinkandEat() throws  InterruptedException
	{
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_F2); 
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN); //1
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN); //2
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN); 
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN); //3
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
//		r.keyPress(KeyEvent.VK_DOWN); //4
//		Thread.sleep(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(3000);
//		r.keyPress(KeyEvent.VK_DOWN); //5
//		Thread.sleep(30);
//		r.keyRelease(KeyEvent.VK_DOWN); 
//		Thread.sleep(3000);
//		r.keyPress(KeyEvent.VK_DOWN); //6
//		Thread.sleep(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_F2); // 2
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN); //1
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN); //2
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN); //3
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
//		r.keyPress(KeyEvent.VK_DOWN); //4
//		Thread.sleep(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(3000);
//		r.keyPress(KeyEvent.VK_DOWN); //5
//		Thread.sleep(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(3000);
//		r.keyPress(KeyEvent.VK_DOWN); //6
//		Thread.sleep(30);
//		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void doThermoment() throws  InterruptedException
	{
		
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_F2); // �o�N
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_UP);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(30000);
	}
	public void doMask()  throws  InterruptedException
	{
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_F2); // �P�_
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_UP);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void doScream()  throws  InterruptedException
	{
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_F2); // ���H
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_UP);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void doVomiting()  throws  InterruptedException
	{
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_F2); // �z�G��
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_UP);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(30);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
