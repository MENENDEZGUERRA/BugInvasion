import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Road here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends Actor
{
    /**
     * Act - do whatever the Road wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int turn;
    public boolean straight;
    
    public Road(boolean straight){
        getImage().scale(60,60);
        this.straight = straight;
    }
    public Road(int turn){
        getImage().scale(60,60);
        this.turn = turn;
    }
    public void act()
    {
        // Add your action code here.
    }
}
