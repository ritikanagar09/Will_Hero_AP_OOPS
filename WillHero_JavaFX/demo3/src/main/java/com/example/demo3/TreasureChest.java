package com.example.demo3;

import java.io.Serializable;

public abstract class TreasureChest extends Game_Objects implements Serializable {
    //Position position;
    private int speed;
    final int max_height=10;

    public TreasureChest(double x, double y) {
        super(x,y);
    }

    public abstract void move();

    public abstract boolean isAlive();

    /*
    public TreasureChest(int speed,int x_coord, int y_coord)
    {
        //this.position=new Position(x_coord,y_coord);
        this.speed = speed;
    }

     */
}
