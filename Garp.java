import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Garp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garp extends Actor
{
    private int frameLeft, frameRight, frameUp, frameDown;
    /**
     * Act - do whatever the Garp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Garp()
    {}
    public void act() 
    {
        movingAndTurning();
        collectingDiamonds();
        foundBomb();
    }
    //deze functie zorgt voor de beweging van de speler garp.
    protected void movingAndTurning()
    {
        if(Greenfoot.isKeyDown("right")){
            setRotation(0);
            animateRight();
            move(5);
            if(foundRock()){
                move(-5);
            }
        }
        if(Greenfoot.isKeyDown("left")) {
            setRotation(0);
            animateLeft();
            move(-5);
            if(foundRock()){
                move(5);
            }
        }
        if(Greenfoot.isKeyDown("up")){
            setRotation(-90);
            animateUp();
            move(5);
            if(foundRock()){
                move(-5);
            }
        }
        if(Greenfoot.isKeyDown("down")){
            setRotation(90);
            animateDown();
            move(5);
            if(foundRock()){
                move(-5);
            }
        }
    }
    //deze functie zorgt dat diamanten (punten) gekregen kunnen worden.
    protected void collectingDiamonds()
    {
        Actor diamond;
        World world;
        List lijst;
        Counter counter;
        
        diamond = getOneObjectAtOffset(0, 0, Diamond.class);
        if(diamond != null){
            world = getWorld();
            world.removeObject(diamond);
            
            lijst = world.getObjects(Counter.class);
            counter = (Counter)lijst.get(0);
            counter.addScore();
            if(counter.getScore()==10){
                Greenfoot.stop();
            }
        }
    }
    //deze functie zorgt dat er een actie gebeurt wanneer de speler tegen een bom aan loopt.
    protected void foundBomb(){
        Actor bomb;
        
        bomb = getOneObjectAtOffset(0, 0, Bomb.class);
        if(bomb != null){
           getWorld().removeObject(bomb);
           getWorld().addObject(new Explosion(), getX(), getY());
           getWorld().removeObject(this);
        }
    }
    //deze functie controleerd of de speler tegen een steen aan loopt.
    protected boolean foundRock()
    {
        Actor rock;
        
        rock = getOneObjectAtOffset(0, 0, Rock.class);
        if(rock != null){
            return true;
        }
        else {
            return false;
        }
    }
    //deze functie animeert de speler waneer hij naar links loopt
    protected void animateLeft()
    {
        if(frameLeft == 0){setImage("left0.png");}
        if(frameLeft == 1){setImage("left0.png");}
        if(frameLeft == 2){setImage("left0.png");}
        if(frameLeft == 3){setImage("left0.png");}
        if(frameLeft == 4){setImage("left0.png");}
        if(frameLeft == 5){setImage("left1.png");}
        if(frameLeft == 6){setImage("left1.png");}
        if(frameLeft == 7){setImage("left1.png");}
        if(frameLeft == 8){setImage("left1.png");}
        else if(frameLeft == 9){
            setImage("left1.png");
            frameLeft = 0;
            return;
        }
        frameLeft++;
    }
    //deze functie animeert de speler waneer hij naar rechts loopt
    protected void animateRight()
    {
        if(frameRight == 0){setImage("right0.png");}
        if(frameRight == 1){setImage("right0.png");}
        if(frameRight == 2){setImage("right0.png");}
        if(frameRight == 3){setImage("right0.png");}
        if(frameRight == 4){setImage("right0.png");}
        if(frameRight == 5){setImage("right1.png");}
        if(frameRight == 6){setImage("right1.png");}
        if(frameRight == 7){setImage("right1.png");}
        if(frameRight == 8){setImage("right1.png");}
        else if(frameRight == 9){
            setImage("right1.png");
            frameRight = 0;
            return;
        }
        frameRight++;
    }
    //deze functie animeert de speler waneer hij naar omhoog loopt
    protected void animateUp()
    {
        if(frameUp == 0){setImage("back0.png");}
        if(frameUp == 1){setImage("back0.png");}
        if(frameUp == 2){setImage("back0.png");}
        if(frameUp == 3){setImage("back0.png");}
        if(frameUp == 4){setImage("back0.png");}
        if(frameUp == 5){setImage("back1.png");}
        if(frameUp == 6){setImage("back1.png");}
        if(frameUp == 7){setImage("back1.png");}
        if(frameUp == 8){setImage("back1.png");}
        else if(frameUp == 9){
            setImage("back1.png");
            frameUp = 0;
            return;
        }
        frameUp++;
    }
    //deze functie animeert de speler waneer hij naar omlaag loopt
    protected void animateDown()
    {
        if(frameDown == 0){setImage("front0.png");}
        if(frameDown == 1){setImage("front0.png");}
        if(frameDown == 2){setImage("front0.png");}
        if(frameDown == 3){setImage("front0.png");}
        if(frameDown == 4){setImage("front0.png");}
        if(frameDown == 5){setImage("front1.png");}
        if(frameDown == 6){setImage("front1.png");}
        if(frameDown == 7){setImage("front1.png");}
        if(frameDown == 8){setImage("front1.png");}
        else if(frameDown == 9){
            setImage("front1.png");
            frameDown = 0;
            return;
        }
        frameDown++;
    }
}
