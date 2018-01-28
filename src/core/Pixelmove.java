package core;

import java.awt.Robot;
import java.awt.Color;

public interface Pixelmove
{
    default public void run() throws java.awt.AWTException
    {
        Robot re = new Robot();
        while(true)
        {
            Color top,topmid,botmid,bot,starter,finisher;
            top = re.getPixelColor(662,355);
            topmid = re.getPixelColor(657,399);
            botmid = re.getPixelColor(662,453);
            bot = re.getPixelColor(663,511);
            starter = re.getPixelColor(650,430);
            finisher = re.getPixelColor(742,455);
            
            float redTop = top.getRed();
            float redTopMid = topmid.getRed();
            float redBotMid = botmid.getRed();
            float redBot = bot.getRed();
            float redStarter = starter.getRed();
            float redFinisher = finisher.getRed();
            
            float greenTop = top.getGreen();
            float greenTopMid = topmid.getGreen();
            float greenBotMid = botmid.getGreen();
            float greenBot = bot.getGreen();
            float greenStarter = starter.getGreen();
            float greenFinisher = finisher.getGreen();
            
            float blueTop = top.getBlue();
            float blueTopMid = topmid.getBlue();
            float blueBotMid = botmid.getBlue();
            float blueBot = bot.getBlue();
            float blueStarter = starter.getBlue();
            float blueFinisher = finisher.getGreen();
            
            float lumTop = (redTop * 0.2126f + greenTop * 0.7152f + blueTop * 0.0722f) / 255;
            float lumTopMid = (redTopMid * 0.2126f + greenTopMid * 0.7152f + blueTopMid * 0.0722f) / 255;
            float lumBotMid = (redBotMid * 0.2126f + greenBotMid * 0.7152f + blueBotMid * 0.0722f) / 255;
            float lumBot = (redBot * 0.2126f + greenBot * 0.7152f + blueBot * 0.0722f) / 255;
            float lumStarter = (redStarter * 0.2126f + greenStarter * 0.7152f + blueStarter * 0.0722f) / 255;
            float lumFinisher = (redFinisher * 0.2126f + greenFinisher * 0.7152f + blueFinisher * 0.0722f) / 255;

            if (lumTop >= 0.5)
            {
                re.mouseMove(722,352);
            }
            
            else if (lumTopMid >= 0.5)
            {
                re.mouseMove(722,404);
            }
            
            else if (lumBotMid >= 0.5)
            {
               re.mouseMove(722,450); 
            }
            
            else if (lumBot >= 0.5)
            {
                re.mouseMove(722,510);
            }
        }
    }
}