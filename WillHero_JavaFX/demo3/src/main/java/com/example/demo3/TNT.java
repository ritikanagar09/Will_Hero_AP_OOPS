package com.example.demo3;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.Serializable;

public class TNT extends Obstacles implements Movable, Serializable {

    private transient ImageView tnt;
    boolean blast_status;

    private int location;


    public TNT(double x, double y) {
        super(x,y);
        tnt = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\TNT.png", 75, 75, false, true));
        tnt.setX(x);
        tnt.setY(y);
        blast_status=false;

        move();
    }

    public void blast(){

        //set opacity=0
//gui blast application
    }

    @Override
    public boolean collide(Hero h) {
        if(!blast_status) {
            h.setDamage(1);
            blast_status=true;
            tnt.setImage(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\blasted_tnt.jpg", 150, 150, false, true));
        }
        else {
            h.set_life_status("dead");
        }

        /*
        if(!blast_status) {
            blast();
            blast_status = true;
            h.update_coins(-10);//dec no of coins by 10
            tnt = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\blasted_tnt.jpg", 75, 75, false, true));
        }
        else {
            h.set_life_status("dead");
        }

         */

        return false;

    }

    public ImageView get_image() {
        return this.tnt;
    }


    @Override
    public void move() {
        TranslateTransition trans= new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        //System.out.println(rect.getX());
        trans.setByY(-20);

        trans.setAutoReverse(true);
        trans.setCycleCount(-1);
        //-1 for indefinite
        trans.setNode(tnt);
        trans.play();

        if(blast_status) trans.stop();
    }
}
