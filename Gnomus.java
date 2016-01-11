import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor
{
    //bij het aanmaken van dit object wordt een random gekozen rotatie gekozen.
    public Gnomus(){
        setRotation();
    }
    public void act() 
    {
        move(5);
        if(atWorldEdge()) {
            move(-5);
            setRotation();
        }
        lookForGarp();
        lookForActor();
    }
    //zet de rotatie.
    protected void setRotation()
    {
        if(Greenfoot.getRandomNumber(100) < 50) { //50% kans
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            else {
                setRotation(getRotation() - Greenfoot.getRandomNumber(180)); 
            }
    }
    //deze functie zoekt of Gnomus de speler (garp) vindt en laat het spel stoppen als dat gebeurt.
    protected void lookForGarp()
    {
        Actor garp;
        
        garp = getOneObjectAtOffset(0, 0, Garp.class);
        if(garp != null){
            Greenfoot.playSound("scream.mp3");
            getWorld().removeObject(garp);
            Greenfoot.stop();
        }
    }
    //deze functie kijkt of Gnomus tegen een actor aan loopt (stenen, bommen, diamanten) en roteerd als dat gebeurt
    protected void lookForActor()
    {
        Actor actor;
        
        actor = getOneObjectAtOffset(0, 0, Actor.class);
        if(actor != null){
            setRotation();
        }
    }
    //deze functie kijtk of Gnomus tegen de rand van de wereld aanloopt
    protected boolean atWorldEdge()
    {
        int x, i, wx, wy, y;
        boolean rand = false;
        
        i = getImage().getWidth()/2;
        x = getX();
        y = getY();
        wx = getWorld().getWidth() -i;
        wy = getWorld().getHeight() -i;
        if(y >= wy){ //onderkant
            rand = true;
        }
        if(x >= wx){ //rand rechts
            rand = true;
        }
        if(x <= i){ //rand links
            rand = true;
        }
        if(y <= i){ //bovenkant
            rand = true;
        }
        return rand;
    }
}
