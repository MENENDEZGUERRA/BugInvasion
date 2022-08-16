import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveDisplay extends Actor
{
    /**
     * Act - do whatever the money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld game;
    public WaveDisplay(){
        setImage(new GreenfootImage("Wave: " + game.waveNumber, 30 , Color.WHITE, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Wave: " + game.waveNumber, 30 , Color.WHITE, new Color(0,0,0,0)));
    }
}
