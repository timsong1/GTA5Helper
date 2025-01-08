package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class DrinkandMed implements Runnable{
	int type;
	
	public DrinkandMed(int type)
	{
		this.type = type;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(type == 1) //³Ü¤ô
		{
			try {
				doDrinkandEat();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type == 2) //¦YÃÄ
		{
			try {
				doTakeMedicine();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void doDrinkandEat() throws AWTException // set how to drink and eat 
	{
		Robot r = new Robot();
		r.delay(10000);
		r.keyPress(KeyEvent.VK_F2); // 1
		r.delay(30);
		r.keyRelease(KeyEvent.VK_F2);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		r.delay(4000);
		r.keyPress(KeyEvent.VK_F2); // 2
		r.delay(30);
		r.keyRelease(KeyEvent.VK_F2);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void doTakeMedicine() throws AWTException // set how to take medicine 
	{
		Robot r = new Robot();
		
		r.delay(4000);
		r.keyPress(KeyEvent.VK_F2); // µo¿N
		r.delay(30);
		r.keyRelease(KeyEvent.VK_F2);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_UP);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_UP);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		r.delay(4000);
		r.keyPress(KeyEvent.VK_F2); // ·P«_
		r.delay(30);
		r.keyRelease(KeyEvent.VK_F2);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_UP);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_UP);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		r.delay(4000);
		r.keyPress(KeyEvent.VK_F2); // ²©½H
		r.delay(30);
		r.keyRelease(KeyEvent.VK_F2);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_UP);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_UP);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		r.delay(4000);
		r.keyPress(KeyEvent.VK_F2); // ¸z­Gª¢
		r.delay(30);
		r.keyRelease(KeyEvent.VK_F2);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_UP);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_UP);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(30);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
