package core;

import java.awt.Robot;
import java.awt.Color;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;


public interface Pixelmove
{
    default public void run() throws java.awt.AWTException
    {
        Robot re = new Robot();
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        int left = 616; //Where to sense change on X
        int botBias = 640; 
        int botMidBias = 590;
        int topMidBias = 530;
        int topBias = 470;
        int mouseleft = left-150; //where to move mouse X
        float lum = 0.4f;
        while(true)
        {
        	System.out.println(main.ActualRuntime.toggleSw);
        	
        	try
        	{
        	    Thread.sleep(1000);
        	    PointerInfo myMouse = MouseInfo.getPointerInfo();
        	    Point myMousePos = myMouse.getLocation();
        	    int x = (int) myMousePos.getX();
        	    int y = (int) myMousePos.getY();
        	    
        	    Color colourInfo;
        	    colourInfo = re.getPixelColor(x, y);
        	    float colourInfoRed = colourInfo.getRed();
        	    float colourInfoGreen = colourInfo.getGreen();
        	    float colourInfoBlue = colourInfo.getBlue();
        	    System.out.print(x + " x " + y + "\n");
        	    System.out.print("R:"+colourInfoRed + " G:"+colourInfoGreen+" B:"+colourInfoBlue+"\n");

        	}
        	catch(InterruptedException ex)
        	{
        	    Thread.currentThread().interrupt();
        	}
        	
        	while(main.ActualRuntime.toggleSw){
        		Color windowYellow,windowGreen;
        	    windowYellow = re.getPixelColor(633, 368);
        	    float windowYellowRed = windowYellow.getRed();
        	    float windowYellowGreen = windowYellow.getGreen();
        	    float windowYellowBlue = windowYellow.getBlue(); 
        	    windowGreen = re.getPixelColor(720, 490);
        	    float windowGreenRed = windowGreen.getRed();
        	    float windowGreenGreen = windowGreen.getGreen();
        	    float windowGreenBlue = windowGreen.getBlue(); 
        	    
        	    //windowGreenRed = 3;
        	    //windowGreenGreen = 200;
        	    //windowGreenBlue = 3;
        	    
        	    
        	    if (windowYellowRed > 200 && windowYellowRed < 220 &&
        	    		windowYellowGreen > 160 && windowYellowGreen < 180 &&
        	    		windowYellowBlue > 80 && windowYellowBlue < 100 &&
        	    	windowGreenRed > 185 && windowGreenRed < 195 &&
        	    		windowGreenGreen > 150 && windowGreenGreen < 160 &&
        	    		windowGreenBlue > 75 && windowGreenBlue < 85 	
        	    		)
        	    {
        	    System.out.print("Located window...\n");	
        	    int loopUntil = 0;
        	    
        	    while (loopUntil < 10)
        	    {
        	    	loopUntil = loopUntil + 1;
	        	//Color top,topmid,botmid,bot,starter,finisher;
	        	Color top,topmid,botmid,bot;
	            top = re.getPixelColor(left,topBias);
	            topmid = re.getPixelColor(left,topMidBias);
	            botmid = re.getPixelColor(left,botMidBias);
	            bot = re.getPixelColor(left,botBias);
	            //starter = re.getPixelColor(600,430);
	            //finisher = re.getPixelColor(660,455);
	            
	            float redTop = top.getRed();
	            float redTopMid = topmid.getRed();
	            float redBotMid = botmid.getRed();
	            float redBot = bot.getRed();
	            //float redStarter = starter.getRed();
	            //float redFinisher = finisher.getRed();
	            
	            float greenTop = top.getGreen();
	            float greenTopMid = topmid.getGreen();
	            float greenBotMid = botmid.getGreen();
	            float greenBot = bot.getGreen();
	            //float greenStarter = starter.getGreen();
	            //float greenFinisher = finisher.getGreen();
	            
	            float blueTop = top.getBlue();
	            float blueTopMid = topmid.getBlue();
	            float blueBotMid = botmid.getBlue();
	            float blueBot = bot.getBlue();
	            //float blueStarter = starter.getBlue();
	            //float blueFinisher = finisher.getGreen();
	            
	            float lumTop = (redTop * 0.2126f + greenTop * 0.7152f + blueTop * 0.0722f) / 255;
	            float lumTopMid = (redTopMid * 0.2126f + greenTopMid * 0.7152f + blueTopMid * 0.0722f) / 255;
	            float lumBotMid = (redBotMid * 0.2126f + greenBotMid * 0.7152f + blueBotMid * 0.0722f) / 255;
	            float lumBot = (redBot * 0.2126f + greenBot * 0.7152f + blueBot * 0.0722f) / 255;
	            //float lumStarter = (redStarter * 0.2126f + greenStarter * 0.7152f + blueStarter * 0.0722f) / 255;
	            //float lumFinisher = (redFinisher * 0.2126f + greenFinisher * 0.7152f + blueFinisher * 0.0722f) / 255;
	
	            if (lumTop >= lum)
	            {
	                re.mouseMove(mouseleft,topBias);
	            }
	            
	            else if (lumTopMid >= lum)
	            {
	                re.mouseMove(mouseleft,topMidBias);
	            }
	            
	            else if (lumBotMid >= lum)
	            {
	               re.mouseMove(mouseleft,botMidBias); 
	            }
	            
	            else if (lumBot >= lum)
	            {
	                re.mouseMove(mouseleft,botBias);
	            }
        	    }
        	    }
        }
    }
}
}
