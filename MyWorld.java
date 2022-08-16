import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //money
    public static int money = 100;
    int basicTowerPrice = 50;
    int worldTime;
    public static int waveNumber = 1;
    public static int life = 5;
    GreenfootSound bgSound = new GreenfootSound("");

    int map [][] ={{0,0,0,0,0,0,0,0,0,0,0},
            {1,1,2,0,3,1,2,0,0,0,0},
            {0,0,1,0,1,0,1,0,0,0,0},
            {0,0,1,0,1,0,1,0,0,0,0},
            {0,0,1,0,1,0,1,0,0,0,0},
            {0,0,1,0,1,0,1,0,0,0,0},
            {0,0,3,1,4,0,1,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,3,1,1,2,0},
            {0,0,0,0,0,0,0,0,0,1,0}};

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 600, 1); 
        menu menu = new menu();
        addObject(menu,720,301);
        addObject(new MoneyDisplay(), 720, 30);
        addObject(new LifeDisplay(), 720, 60);
        addObject(new WaveDisplay(), 720, 90);
        Level1();
        prepare();
    }

    public void act(){
        addInTowers();
        spawnWave();
        worldTime++;
        //GAME OVER SYSTEM
        if (life <= 0) {
                GameOver();
        }
        //WIN CONDITION
        if (waveNumber >= 10){
            YouWin();
        }
    }
    
    public void spawnWave(){
        if(worldTime % 20 == 0){
            addObject(new Enemy(waveNumber), 1, 90);
        }
        if(worldTime % 200 == 0){
            addObject(new Enemy(waveNumber), 1, 90);
        }
        if(worldTime % 400 == 399){
            waveNumber++;
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void Level1()
    {
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(map[j][i] == 1){
                    addObject(new Road(true), 30 + i * 60, 30 + j * 60);
                }
                if(map[j][i] == 2){
                    addObject(new Road(90), 30 + i * 60, 30 + j * 60);
                }
                if(map[j][i] == 3){
                    addObject(new Road(0), 30 + i * 60, 30 + j * 60);
                }
                if(map[j][i] == 4){
                    addObject(new Road(270), 30 + i * 60, 30 + j * 60);
                }
                if(map[j][i] == 5){
                    addObject(new Road(180), 30 + i * 60, 30 + j * 60);
                }
            }
        }
    }

    public void addInTowers(){
        if(Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() == null && money >= basicTowerPrice){
            addObject(new tower1(), (Greenfoot.getMouseInfo().getX()/60)*60+30,
                (Greenfoot.getMouseInfo().getY()/60)*60+30);
            money -= basicTowerPrice;
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
    
    public void GameOver(){
        addObject(new GameOverScreen(),getWidth()/2,getHeight()/2);  
        Greenfoot.stop();
    }
    
    public void YouWin(){
        addObject(new YouWin(),getWidth()/2,getHeight()/2);   
        Greenfoot.stop();
    }
}
