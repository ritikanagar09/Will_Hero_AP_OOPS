package com.example.demo3;

import javafx.scene.Group;

public class Coin extends Game_Objects{
    private transient Group coin;
    public Coin(Group c) {
        super(c.getLayoutX(), c.getLayoutY());
        coin=c;
    }
    @Override
    public boolean collide(Hero h) {
        return false;
    }
    public Group getGroup() {
        return this.coin;
    }
}
