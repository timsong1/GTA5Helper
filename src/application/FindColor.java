package application;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class FindColor {
	
	final Color green = new Color(28,135,28);
	final Color blue = new Color(20,145,175);
	final Color pink = new Color(205,20,120);
	
	//Emoji color
	final Color yellow = new Color(200,165,70);//+-20  +-20 +-20
	final Color yellow2 = new Color(190,120,60);
	final Color e_green = new Color(40,150,65);	//+- 40  +-60  +-65
	final Color e_white = new Color(200,200,200); 
	final Color e_red = new Color(170,80,55);
	final Color e_blue = new Color(85,135,170);
	Mat vomiting;
	Mat thermoment;
	Mat scream;
	Mat mask;
	Mat cvpink;
	Mat cvblue;
	
	BufferedImage image ;
	int[] location = new int[2];
	int[] a = new int[2];
	int distance;
	public FindColor(BufferedImage image)
	{
		this.image = image;
	}
	public FindColor()
	{
		try {
			this.image = getScreenShot();
			String osName = System.getProperty("os.name");
	        String opencvpath = System.getProperty("user.dir");
	        if(osName.startsWith("Windows")) {
	            int bitness = Integer.parseInt(System.getProperty("sun.arch.data.model"));
	            if(bitness == 32) {
	                opencvpath=opencvpath+"\\Resource\\opencv\\x86\\";
	            }
	            else if (bitness == 64) { 
	                opencvpath=opencvpath+"\\Resource\\opencv\\x64\\";
	            } else { 
	                opencvpath=opencvpath+"\\Resource\\opencv\\x86\\"; 
	            }           
	        } 
	        else if(osName.equals("Mac OS X")){
	            opencvpath = opencvpath+"Your path to .dylib";
	        }
	       
	        System.out.println(opencvpath);
	        System.load(opencvpath + Core.NATIVE_LIBRARY_NAME + ".dll");
	        Properties sysProps = System.getProperties();
	        String winEdition = sysProps.get("os.name").toString();
	       
	    	
	        if(winEdition.contains("10"))
	        {
	        	System.out.println("************");
	        	vomiting = Highgui.imread("Resource/img/vomiting.png");
		        thermoment = Highgui.imread("Resource/img/thermoment.png");
		    	scream = Highgui.imread("Resource/img/scream.png");
		    	mask= Highgui.imread("Resource/img/mask.png");
	        	
	        }
	        else if(winEdition.contains("11"))
	        {
	        	vomiting = Highgui.imread("Resource/img/vomiting_b.png");
	            thermoment = Highgui.imread("Resource/img/thermoment_b.png");
	        	scream = Highgui.imread("Resource/img/scream_b.png");
	        	mask= Highgui.imread("Resource/img/mask_b.png");
	        }
	        else
	        {
	        	vomiting = Highgui.imread("Resource/img/vomiting.png");
	            thermoment = Highgui.imread("Resource/img/thermoment.png");
	        	scream = Highgui.imread("Resource/img/scream.png");
	        	mask= Highgui.imread("Resource/img/mask.png");
	        }
	        
	        
//	        vomiting = Highgui.imread("Resource/img/vomiting.png");
//	        thermoment = Highgui.imread("Resource/img/thermoment.png");
//	    	scream = Highgui.imread("Resource/img/scream.png");
//	    	mask= Highgui.imread("Resource/img/mask.png");
	        
	        
//	    	cvpink = Highgui.imread("Resource/img/pink.png");
	    	cvblue = Highgui.imread("Resource/img/blue1.png");
	    	File file = new File("Resource/img/sccccc.png");
	    	int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
			Size size = new Size(20*(width/1980.0),20*(height/1080.0));

			Imgproc.resize(vomiting, vomiting, size);
			Imgproc.resize(thermoment, thermoment, size);
			Imgproc.resize(scream, scream, size);
			Imgproc.resize(mask, mask, size);
//			Imgproc.resize(cvpink, cvpink, new Size(24*(width/1980.0),24*(height/1080.0)));
			Imgproc.resize(cvblue, cvblue, new Size(24*(width/1707.0),24*(height/960.0)));
//	        try {
//				ImageIO.write(image, "png", file);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}catch(Exception e) {
			System.out.println("finColor 建構式出錯");
			e.printStackTrace();
		}
		

	}
	public void setImage(BufferedImage image)
	{
		this.image = image;
	}
	public boolean isFind()
	{
		if(location[0] != 0 && location[1] !=0)
			return true;
		else 
			return false;
	}
	
	public boolean findEmoji()
	{
		if(location[0] != 0 && location[1] != 0)
		{
			int x = location[0];
			int y = location[1];
			
			for(int i = x + 10; i < x + distance ; i++)
			{
				for(int x1 = i -15 ; x1 < i+15 ; x1++)
					for(int y1 = y-15 ; y1 < y+15 ; y1++)
					{
						Color r = new Color(image.getRGB(x1, y1));
						if(findYellow(r))
						{
							System.out.println("黃色位置: ("+x1+","+y1+")");
							
							a[0] = x1;
							a[1] = y1;
							
							
							return true;
						}
						r = null;
					}
			}
			return false;
		}
		
		
			
		return false;
	}
	public int cvFindEmoji() 
	{
		distance = 40;
		if(location[0] != 0 && location[1] != 0 && distance > 0 )
		{
			
			File file = new File("Resource/img/screen.png");
	        try {
	        	BufferedImage img = getScreenShot();
				ImageIO.write(img, "png", file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Mat img = Highgui.imread("Resource/img/screen.png");
	        

	        if(img.cols() == 0)
	        {
	        	System.out.println("img.cols() == 0");
	        	return -1;
	        }
	        int result_cols = img.cols() - scream.cols() + 1;
	        int result_rows = img.rows() - scream.rows() + 1;
	        Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);         //腸胃炎
	        Imgproc.matchTemplate(img, vomiting, result, Imgproc.TM_CCORR_NORMED);
	        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
	        
	        // / Localizing the best match with minMaxLoc
	        MinMaxLocResult mmr = Core.minMaxLoc(result);
	        Point matchLoc  = mmr.maxLoc;
	        System.out.println("match point : " +matchLoc.x+","+matchLoc.y);
	        System.out.println("腸胃炎distance : "+(matchLoc.x - location[0]));
	        if(matchLoc.x > location[0] && matchLoc.x - location[0] < distance)
	        {
	        	if(matchLoc.y - location[1]  < 65 && matchLoc.y -location[1] >40)
	        	{
	        		System.out.println("找到腸胃炎");
	        		return 1;
	        	}
	        }
	        result = null;
	        mmr = null;
	        matchLoc = null; 
	        
	        result = new Mat(result_rows, result_cols, CvType.CV_32FC1);    		//痔瘡
	        Imgproc.matchTemplate(img, scream, result, Imgproc.TM_CCORR_NORMED);
	        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
	        
	        // / Localizing the best match with minMaxLoc
	        mmr = Core.minMaxLoc(result);
	        matchLoc  = mmr.maxLoc;
	        if(matchLoc.x > location[0] && matchLoc.x - location[0] < distance)
	        {
	        	if(matchLoc.y - location[1]  < 70 && matchLoc.y -location[1] >40)
	        	{
	        		System.out.println("找到痔瘡" + matchLoc.x+","+matchLoc.y);
	        		return 3;
	        	}
	        }
	        result = null;
	        mmr = null;
	        matchLoc = null;
	        
	        result = new Mat(result_rows, result_cols, CvType.CV_32FC1);    		//感冒
	        Imgproc.matchTemplate(img, mask, result, Imgproc.TM_CCORR_NORMED);
	        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
	        
	        // / Localizing the best match with minMaxLoc
	        mmr = Core.minMaxLoc(result);
	        matchLoc  = mmr.maxLoc;
	        if(matchLoc.x > location[0] && matchLoc.x - location[0] < distance)
	        {
	        	if(matchLoc.y - location[1]  < 65 && matchLoc.y -location[1] >40)
	        	{	System.out.println("找到感冒");
	        		return 4;
	        	}
	        }
	        result = null;
	        mmr = null;
	        matchLoc = null;
	        
	        result = new Mat(result_rows, result_cols, CvType.CV_32FC1);    		//發燒
	        Imgproc.matchTemplate(img, thermoment, result, Imgproc.TM_CCORR_NORMED);
	        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
	        
	        // / Localizing the best match with minMaxLoc
	        mmr = Core.minMaxLoc(result);
	        matchLoc  = mmr.maxLoc;
	        
	        if(matchLoc.x > location[0] && matchLoc.x - location[0] < distance)
	        {
	        	if(matchLoc.y - location[1]  < 65 && matchLoc.y -location[1] >40)
	        	{
	        		System.out.println("找到發燒");
	        		return 2;
	        	}
	        }
	        result = null;
	        mmr = null;
	        matchLoc = null;
		}
		else
		{
			System.out.println("有點怪 : cvFindEmoji");
		}
		
		return 0;
	}
	public void CVdetermineLocation()
	{
		File file = new File("Resource/img/screen1.png");
        try {
        	BufferedImage img = getScreenShot();
			ImageIO.write(img, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Mat img = Highgui.imread("Resource/img/screen1.png");
        
        System.out.println("img的寬: "+img.width()+",高: "+img.height());
        if(img.cols() == 0)
        {
        	System.out.println("img.cols() == 0");
        	return ;
        }
        int result_cols = img.cols() - scream.cols() + 1;
        int result_rows = img.rows() - scream.rows() + 1;
        Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);         
        Imgproc.matchTemplate(img, cvblue, result, Imgproc.TM_CCORR_NORMED);
        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
        
        // / Localizing the best match with minMaxLoc
        MinMaxLocResult mmr = Core.minMaxLoc(result);
        Point matchLoc  = mmr.maxLoc;
        System.out.println("match point : " +matchLoc.x+","+matchLoc.y);
        
        int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        if(matchLoc.y > img.height()*1/2.0  && matchLoc.y < img.height()*5/6.0 ) 
        {
        	System.out.println("match的點y有在"+img.height()*1/2.0+" 到 "+img.height()*5/6.0+" 之間");
        	location[0] = (int)matchLoc.x;
        	location[1] = (int)matchLoc.y;
        }
        else
        {
        	location[0] = 0;
        	location[1] = 0;
        }
	}
	
	public void determineLocation()
	{
		if(image != null)
		{
			int count = 0;
			for(int x = 0 ; x < image.getWidth() ; x++)
				for(int y = 0 ; y < image.getHeight() ; y++)
				{		
					Color r = new Color(image.getRGB(x, y));
					if(findGreen(r))
					{
//						System.out.println("       找到-- 綠色 -- x = "+x+"  y = "+y);
						for(int y2 = y+1 ; y2 < image.getHeight() ; y2++)
						{
							Color r2 = new Color(image.getRGB(x, y2));
							if(findLightblue(r2))
							{
								for(int y3 = y2+1 ; y3 < image.getHeight() ; y3++)
								{
									Color r3 = new Color(image.getRGB(x, y3));
									if(findPink(r3))
									{
										System.out.println("找到粉紅色   ("+x+","+y3+")");
										location[0] = x;
										location[1] = y3;
										distance = y3 - y2;
										return;
									}
									r3 = null;
								}
							}
							r2 = null;
						}
					}
					r = null;	

				}
			System.out.println("沒找到");
		}
		
	}
	public void changeImage()
	{
		this.image = null;
		this.image = getFullScreenShot();		
	}
	public void changeSmallImage()
	{
		this.image = null;
		this.image = getScreenShot();
	}
	public boolean findYellow(Color r) 
	{
		
		if(Math.abs(r.getRed()-yellow.getRed()) <= 20
				&& Math.abs(r.getGreen()-yellow.getGreen()) <= 20
				&& Math.abs(r.getBlue()-yellow.getBlue()) <= 20)
		{
//			System.out.print(r.getRed()+" , "+r.getGreen()+" , "+r.getBlue());	
			r = null;
			return true;
		}
		if(Math.abs(r.getRed()-yellow2.getRed()) <= 10
				&& Math.abs(r.getGreen()-yellow2.getGreen()) <= 10
				&& Math.abs(r.getBlue()-yellow2.getBlue()) <= 10)
		{
//			System.out.print(r.getRed()+" , "+r.getGreen()+" , "+r.getBlue());	
			r = null;
			return true;
		}
						
		r = null;
		return false;		
			
	}
	public boolean findGreen(Color r) 
	{
		
		if(Math.abs(r.getRed()-green.getRed()) <= 38  
				&& Math.abs(r.getGreen()-green.getGreen()) <= 23
				&& Math.abs(r.getBlue()-green.getBlue()) <= 15)
		{
//			System.out.print(r.getRed()+" , "+r.getGreen()+" , "+r.getBlue());	
			r = null;
			return true;
		}
						
		r = null;
		return false;		
			
	}
	public boolean findLightblue(Color r)
	{
		if(Math.abs(r.getRed()-blue.getRed()) <= 30  
				&& Math.abs(r.getGreen()-blue.getGreen()) <= 40
				&& Math.abs(r.getBlue()-blue.getBlue()) <= 45)
		{
//			System.out.println(r.getRed()+" , "+r.getGreen()+" , "+r.getBlue());	
			r = null;
			return true;
		}
						
		r = null;
		return false;		
		
	}
	public boolean findPink(Color r)
	{
		if(Math.abs(r.getRed()-pink.getRed()) <= 25  
				&& Math.abs(r.getGreen()-pink.getGreen()) <= 25
				&& Math.abs(r.getBlue()-pink.getBlue()) <= 30)
		{
			System.out.print(r.getRed()+" , "+r.getGreen()+" , "+r.getBlue());	
			r = null;
			return true;
		}				
		r = null;
		
		
		
		return false;
	}
	public int[] findGreen() throws AWTException
	{
		if(image != null)
		{
			int count = 0;
			for(int x = 0 ; x < image.getWidth()/2 ; x++)
				for(int y = image.getHeight()/2 ; y < image.getHeight() ; y++)
				{
					Color r = new Color(image.getRGB(x, y));
					
					if(Math.abs(r.getRed()-green.getRed()) <= 38  
							&& Math.abs(r.getGreen()-green.getGreen()) <= 23
							&& Math.abs(r.getBlue()-green.getBlue()) <= 15)
					{
						System.out.print("找到 x = "+x+"  y = "+y+"       ");
						System.out.println(r.getRed()+" , "+r.getGreen()+" , "+r.getBlue());
						count++;
					}
						
					r = null;
				}
			System.out.println("找到 "+count+" 個");
		}
		
		return null;
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
	public BufferedImage getScreenShot()
	{
		BufferedImage bfimage = null;
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		System.out.println("---------------width:"+width+" height:"+height);
		try {
			Robot robot = new Robot();
			bfimage = robot.createScreenCapture(new Rectangle(0,height/2,width/3,height/2));
			
			robot = null;
		} catch(AWTException e) {
			e.printStackTrace();
		}
		return bfimage;
	}
	
	private String getMonitorSizes() {        
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice[]    gs = ge.getScreenDevices();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < gs.length; i++) {
	        DisplayMode dm = gs[i].getDisplayMode();
	        sb.append(i + ", width: " + dm.getWidth() + ", height: " + dm.getHeight() + "\n");
	    }    
	    return sb.toString();
	}
}
