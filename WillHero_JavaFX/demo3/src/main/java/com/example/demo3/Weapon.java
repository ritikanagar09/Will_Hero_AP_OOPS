package com.example.demo3;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Weapon implements Serializable {
    private int damage;
    private transient ImageView weapon;

    Weapon(String type) {
        if(type.equals("sword")) {
            weapon = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\Sword.gif", 20, 20, false, true));
            damage=5;
        }
        else {
            weapon = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\Hammer.gif", 20, 20, false, true));
            damage=3;
        }
    }

    public int get_damage() {return this.damage;}
    public ImageView getImage() {return this.weapon;}
    public void setDamage(int d) {this.damage=d;}
}
