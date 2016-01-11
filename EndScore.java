import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class EndScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScore extends Score
{
    private long startTime;
    //bij het aanmaken wordt de begintijd opgeslagen
    public EndScore(){
        startTime = System.currentTimeMillis();
    }
    //de functie getelapsedtime berekend hoeveeltijd tussen de aanmaak van het object en wanneer deze functie wordt aangeroepen
    public String getElapsedTime(){
        int uren, minuten, seconden;
        String duur;
        long duration;
        
        duration = System.currentTimeMillis() - startTime;
        
        seconden = (int)(duration / 1000);
        uren = seconden / 3600;
        seconden %= 3600;
        minuten = (int) (seconden / 60);
        seconden %= 60;
        
        duur = String.format("Duur: %02d:%02d:%02d", uren, minuten, seconden);
        return duur;
    }
    //deze functie maakt de scorebord afbeelding en controleerd of de speler gewonnen heeft.
    public void setEndImage(int score){
        GreenfootImage image;
        Dimension dim;
        String tekst, resultaat;
        
        if(score==10)
            resultaat = "je hebt gewonnen..!";
        else
            resultaat = "je hebt verloren..!";
        tekst = getElapsedTime();
        tekst += "\n\r" + "aantal diamanten: " + score + "\n\r" + resultaat;
        image = new GreenfootImage(10, 10);
        
        dim = getTextDimensions(image, tekst);
        dim.height *= 4;
        dim.width /= 2;
        image.scale(dim.width, dim.height);
        
        Font font = new Font ("Calivri", Font.BOLD, 12);
        image.setFont(font);
        
        image.setColor(new Color(255, 255, 255, 191));
        image.fillRect(0,0, dim.width, dim.height);
        image.setColor(new Color(128, 128, 128, 128));
        image.fillRect(0, 4, 4, dim.height);
        image.fillRect(4, dim.height - 4, dim.width - 8, dim.height - 4);
        
        
        setImage(image);
        image.setColor(new Color(100, 100, 255));
        image.drawString(tekst, dim.width / 8, 20);
    }
}
