package application;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

import javafx.fxml.Initializable;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;

public class imgProcess implements Initializable{
	
	public BufferedImage image ;
	final String target = "[xxx]請按橫排數字鍵x(超時將視為挂機並踢出伺服器)";
	public String text;
	public imgProcess()
	{
		image = getFullScreenShot();
		image = image.getSubimage(0, 0, image.getWidth(), image.getHeight()/4);
		text = getText();
	}
	public BufferedImage getFullScreenShot()
	{
		BufferedImage bfimage = null;
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		try {
			Robot robot = new Robot();
			bfimage = robot.createScreenCapture(new Rectangle(0,0,width,height));
			robot = null;
		} catch(AWTException e) {
			e.printStackTrace();
		}
		return bfimage;
	}
	public String getText()
	{
		Tesseract instance = new Tesseract();
		instance.setDatapath("Resource/tessdata");
		instance.setLanguage("chi_tra");
		
		String a;
		try {
			a = instance.doOCR(image);		
			instance = null;
			return a.replaceAll(" ", "").trim();
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public String detect()  //找圖片有沒有出現target
	{
		int count = 0; 
		if(text == null)
			return null;
		for(int i = 0 ; i < text.length()-(target.length()-1) ; i++)
		{
			for(int j = 0 ; j < target.length() ; j++)
			{
				if(target.charAt(j) == 'x')
					continue;
				else
				{
					if(text.charAt(i+j) == target.charAt(j))
						count++;
					if(count > 7)
					{
//						System.out.println("在第 "+(i+j)+" 個 :"+text.charAt(i+j));
						return text.substring(i,i+27);
					}
				}
			}
		}
		return null;
	}
	public int findNumber()
	{
		String input = detect();
		System.out.println("input 為 : "+input);
		if(input == null)
			return -1;
		try {
			for(int i = 0 ; i < target.length() ; i++)
			{
		
				if(target.charAt(i) == 'x')
					continue;
				int pos = input.indexOf(target.charAt(i));
				if(pos == -1)
					continue;
				else
				{
					System.out.println("pos位置為 : "+pos);
					System.out.println("i位置為 : "+i);
					if(i <= 12)
					{
						int output = input.charAt(pos + (12 - i))-48;
						if(output >= 0 && output <= 9)
						{
							System.out.println("找到數字 : "+output);
							return output;
						}
						else
							continue;
					}
					else
					{
						int output = input.charAt(pos + (i - 12))-48;
						if(output >= 0 && output <= 9)
						{
							System.out.println("找到數字 : "+output);
							return output;
						}
						else
							continue;
					}
				}
			}
		}catch(Exception e)
		{
			System.out.println("findNumber() 報錯");
			return -1;
		}
		
		
		
		return -1;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public static Mat bufferedImageToMat(BufferedImage bi) {
		  Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
		  byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
		  mat.put(0, 0, data);
		  return mat;
	}
}
