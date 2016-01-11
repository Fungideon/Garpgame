import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GarpsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GarpsWorld extends World
{
    private GreenfootSound sound;
    private EndScore endScore;
    private Counter counter;
    /**
     * Constructor for objects of class GarpsWorld.
     * 
     */
    public GarpsWorld()
    {    
        // Create a new world with 700x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1);
        //Start de functie populate the world.
        populateTheWorld();
        //zet het geluid bestand.
        sound = new GreenfootSound("Xiao Mei Mei.mp3");
    }
    //zodra greenfoot wordt gestart word de muziek afgespeeld en de teller gestart die de speeldtijd bijhoudt.
    public void started(){
        sound.play();
        endScore = new EndScore();
    }
    //zodra greenfoot gestopt wordt word de score opgevraagt,
    //de score doorgestuurd naar de functie van de teller die de scorebord weergeeft
    //en het geluid wordt gestopt
    public void stopped(){
       int score;

       score = counter.getScore();
       endScore.setEndImage(score);
       addObject(endScore, getWidth() / 2, getHeight() / 2);
       sound.stop();
    }
    //deze functie zorgt dat alle objecten op de wereld worden gezet en op de juiste manier getekend worden
    //zodat de speler niet onder de ander objecten terecht komt.
    protected void populateTheWorld(){
        int regel, kolom;
        
        addObject(new Garp(), 350, 250);
        addObject(new Gnomus(), Greenfoot.getRandomNumber(646) + 27, Greenfoot.getRandomNumber(348) +26);
        for(int teller = 0; teller < 10; teller++){
            addObject(new Diamond(), Greenfoot.getRandomNumber(660) + 20, Greenfoot.getRandomNumber(360) + 20);
        }
        for(int teller = 0; teller < 6; teller++){
            addObject(new Rock(), Greenfoot.getRandomNumber(642) + 29, Greenfoot.getRandomNumber(342) + 29);
        }
        for(int teller = 0; teller < 4; teller++){
            addObject(new Bomb(), Greenfoot.getRandomNumber(644) + 28, Greenfoot.getRandomNumber(344) + 29);
        }
        counter = new Counter();
        regel = getHeight() - counter.getImage().getHeight() / 2 -1;
        kolom = counter.getImage().getWidth() / 2 + 1;
        addObject(counter, kolom, regel);
        setPaintOrder(EndScore.class, Counter.class, Garp.class, Gnomus.class, Diamond.class, Bomb.class, Rock.class);
    }
}
