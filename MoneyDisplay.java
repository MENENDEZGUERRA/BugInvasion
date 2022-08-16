import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyDisplay extends Actor
{
    /**
     * Act - do whatever the money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld game;
    public MoneyDisplay(){
        setImage(new GreenfootImage("Currency: " + game.money, 30 , Color.WHITE, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Currency: " + game.money, 30 , Color.WHITE, new Color(0,0,0,0)));
    }
}
