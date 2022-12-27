package com.example.demo3;

import java.io.Serializable;

public abstract class Game_Objects implements Serializable {
    private double x;
    private double y;


    public Game_Objects(double _x, double _y){
        x=_x;
        y=_y;
    }

    public abstract boolean collide(Hero h);
//to be overriden

}
