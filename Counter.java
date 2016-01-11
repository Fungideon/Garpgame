import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Score
{
    private int score;
    //bij het maken van het object Counter word de schermafbeelding voor gemaakt
    public Counter(){
        String scoreText;
        GreenfootImage image;
        Dimension dim;
        
        score = 0;
        scoreText = "Aantal diamanten: 00";
        
        image = new GreenfootImage(10, 100);
        dim = getTextDimensions(image, scoreText);
        image.scale(dim.width, dim.height);
        setImage(image);
        image.setColor(new Color(0, 0, 0));
        image.drawString(scoreText, 0, dim.height);
    }
    //addscore zorgt dat andere functies punten kunnen doorgeven
    public void addScore(){
        score ++;
        updateImage();
    }
    //getscore zorgt dat functies de score kunnen oproepen
    public int getScore(){
        return score;
    }
    //update image update de image met het nieuwe totaal score
    protected void updateImage(){
        String scoreText;
        Dimension dim;
        GreenfootImage image;
        
        image = getImage();
        image.clear();
        scoreText = "Aantal diamanten: " + score;
        dim = getTextDimensions(image, scoreText);
        image.setColor(new Color(0, 0, 0));
        image.drawString(scoreText, 0, dim.height);
    }
}
