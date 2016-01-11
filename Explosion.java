import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private GreenfootImage[] images;
    private boolean geluid;
    private int action, increment;
    //maakt een array van afbeeldingen aan uit 1 afbeelding door de groote te veranderen
    public Explosion(){
        int size, baseSize, verschil, teller;
        
        images = new GreenfootImage[8];
        GreenfootImage baseImage = new GreenfootImage("explosion.png");
        
        baseSize = baseImage.getWidth();
        verschil = baseSize / 8;
        size = 0;
        
        for(teller = 0; teller < 8; teller++){
            size += verschil;
            images[teller] = new GreenfootImage(baseImage);
            images[teller].scale(size, size);
        }
        geluid = true;
        increment = 1;
    }
    //animeerd de ontploffing en speelt geluid af en stopt zodra de animatie is afgelopen
    public void act() 
    {
        setImage(images[action]);
        action += increment;
        
        if(geluid){
            Greenfoot.playSound("explosion.wav");
            geluid = false;
        }
        if(action > 7){
            increment = -1;
            action += increment;
        }
        if(action < 0){
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
}
