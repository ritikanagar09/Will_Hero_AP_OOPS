package com.example.demo3;

import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.io.Serializable;

public class Hero implements Serializable {
    private String name;
    private int location;
    private int coins;
    private double[] position;
    private Helmet helmet;
    private String life_status;
    private transient Rectangle rect;
    private boolean hitPlatform;
    private int no_of_lives;
    private double x;
    private double y;
    private boolean resurrected;

    public Hero(Rectangle r, String n) throws IOException {
        name=n;
        rect=r;
        life_status="alive";
        coins=0;
        helmet=new Helmet();
        hitPlatform=false;
        no_of_lives=20;
        x=rect.getX();
        y=rect.getY();
        resurrected=false;
    }

    public Rectangle gethero() {
        return this.rect;
    }
    public boolean getHitPlatform() {return this.hitPlatform;}
    public void setHitPlatform(boolean b) {this.hitPlatform=b;}

    public Weapon get_weapon() {
        return this.helmet.get_weapon_in_use();
    }
    public void set_weapon(Weapon w) {
        this.helmet.set_weapon_in_use(w);
    }
    public void setName(String n) {this.name=n;}
    public void set_life_status(String s) {
        this.life_status=s;
    }
    public void update_coins(int c) {
        coins+=c;
    }
    public int get_coins() {return this.coins;}
    public String get_life_status() {return this.life_status;}
    public int get_damage() {return this.helmet.get_damage();}
    public void setDamage(int d) {
        this.no_of_lives-=d;
    }
    public boolean getResurrected() {return this.resurrected;}
    public void setResurrected() {
        this.resurrected=true;
        rect.relocate(50,50);
    }
    public boolean has_weapon() {
        if(this.helmet.get_weapon_in_use()==null) return false;
        else return true;
    }
}