import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class tower1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tower1 extends Actor
{
    /**
     * Act - do whatever the tower1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int fireRate = 0;
    public tower1()
    {
        
    }
    public void act()
    {
        enemyDetector();
    }
    public void enemyDetector(){
        fireRate++;
        List<Enemy> enemies = getObjectsInRange(100, Enemy.class);
        for(Enemy eachEnemy : enemies)
        {
            if(fireRate > 15){
                orbes orbes = new orbes();
                getWorld().addObject(orbes, getX(), getY());
                orbes.turnTowards(eachEnemy.getX(), eachEnemy.getY());
                fireRate = 0;
        }
        }
    }
}
