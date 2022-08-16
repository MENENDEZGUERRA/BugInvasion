import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld world;
    public int health = 5;
    public int speed = 1;
    public int reward = 5;
    
    public Enemy(int level){
        if(level >= 1 && level < 5){
            setImage("ant3.png");
            health = 2;
            speed = 3;
            reward = 1;
        }
        if(level >= 5 && level < 7){
            setImage("bt1.png");
            health = 5;
            speed = 1;
            reward = 20;
        }
        if(level >= 7){
            setImage("ant3.png");
            health = 2;
            speed = 5;
            reward = 5;
        }
        if(level == 10){
            //YOU WIN SYSTEM
        }
    }
    public void act()
    {
        enemyMovement();
        orbHit();
    }
    
    public void enemyMovement(){
        move(speed);
        List <Road> road90 = getObjectsAtOffset(-30, 0, Road.class);
        for(Road roads: road90){
            if(roads.straight == false && getRotation() == 0){
                setRotation(roads.turn);
            }
        }
        List <Road> road0 = getObjectsAtOffset(0, -30, Road.class);
        for(Road roads: road0){
            if(roads.straight == false && getRotation() == 90){
                setRotation(roads.turn);
            }
        }
        List <Road> road180 = getObjectsAtOffset(0, 30, Road.class);
        for(Road roads: road180){
            if(roads.straight == false && getRotation() == 270){
                setRotation(roads.turn);
            }
        }
        List <Road> road270 = getObjectsAtOffset(30, 0, Road.class);
        for(Road roads: road270){
            if(roads.straight == false && getRotation() == 189){
                setRotation(roads.turn);
            }
        }
    }
    
    public void orbHit(){
        Actor orbes = getOneIntersectingObject(orbes.class);
        if(orbes != null){
            health--;
            getWorld().removeObject(orbes);
        }
        if(health <=0){
            world.money += reward;
            getWorld().removeObject(this);
        }
        else if(isAtEdge()){
            getWorld().removeObject(this);
            world.life -= 1;
        }
    }
}
