package com.example.demo3;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.Serializable;

public class Platform extends Game_Objects implements Serializable {

    int height;
    int location;
    int width;
    private transient ImageView platform;
    double x;
    double y;
    public Platform() {
        super(0,0);
        platform = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\platforms.gif", 300, 100, false, true));
    }

    public void setX(double x) {
        this.x=x;
        platform.setX(x);
    }

    public void setY(double y) {
        this.y=y;
        platform.setY(y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public ImageView get_image() {
        return this.platform;
    }

    public int get_location(){
        return this.location;
    }

    public int get_height(){
        return this.height;
    }


    public int get_width(){
        return this.width;
    }
    @Override
    public boolean collide(Hero h) {

        /*
        TranslateTransition trans= new TranslateTransition();
        trans.setDuration(Duration.seconds(2));
        //System.out.println(rect.getX());
        //trans.setToY(h.gethero().getY()-150);
        trans.setByY(-200);

        trans.setAutoReverse(true);
        trans.setCycleCount(2);
        //-1 for indefinite
        trans.setNode(h.gethero());
        trans.play();



         */
        h.setHitPlatform(true);
        return true;
        // what happens when platform collides with
    }
}

