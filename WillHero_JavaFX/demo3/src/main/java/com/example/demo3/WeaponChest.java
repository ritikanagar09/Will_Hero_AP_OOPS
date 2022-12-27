package com.example.demo3;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Random;

public class WeaponChest extends TreasureChest implements Serializable {
    private transient ImageView weaponchest;
    private Weapon w=null;
    private String life_status;
    private transient ImagePattern img;

    transient Random rand = new Random();

    transient TranslateTransition trans= new TranslateTransition();

    @Override
    public void move() {
        trans.setDuration(Duration.seconds(0.5));
        //System.out.println(rect.getX());
        trans.setByY(-50);

        trans.setAutoReverse(true);
        trans.setCycleCount(Animation.INDEFINITE);
        //-1 for indefinite
        trans.setNode(weaponchest);
        trans.play();

        //translate chest code

        //up and down
    }

    public WeaponChest(double x, double y) {
        super(x,y);
        weaponchest = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\weapon chest.gif", 100, 75, false, true));
        weaponchest.setX(x);
        weaponchest.setY(y);

        int r=rand.nextInt(2);
        if(r==0) {
            w=new Weapon("sword");
            img=new ImagePattern(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\sword_hero.png",50,50,false,true));
        }
        else {
            w=new Weapon("hammer");
            img=new ImagePattern(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\hammer-hero.png",50,50,false,true));
        }

        life_status="alive";

        move();
    }

    public ImageView get_image() {
        return this.weaponchest;
    }

    @Override
    public boolean collide(Hero h){
            if(isAlive()) {
                h.set_weapon(w);
                h.gethero().setFill(img);
                //weaponchest.setOpacity(0);
                life_status = "dead";
                weaponchest.setImage(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\ChestOpen.png", 100, 75, false, true));
                trans.stop();
            }
            return false;

        //open weaponchest code
    }

    //getter
    public Weapon get_weapon(){
        return this.w;
    }

    public boolean isAlive() {
        return life_status.equals("alive");
    }
}
