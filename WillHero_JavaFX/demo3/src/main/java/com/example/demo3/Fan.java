package com.example.demo3;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.Serializable;

public class Fan extends Game_Objects implements Movable, Serializable {

    private transient ImageView fan;

    //private Position position;
    private  int speed;
    private Hero h;
    public Fan(double x, double y){
        super(x,y);

        fan = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\Fan.png", 200, 200, false, true));
        fan.setX(x);
        fan.setY(y);

        move();
    }
    private void rotate(){
        //move or rotate animation


    }

    public boolean hit_fan(Object obj){

        if(true)//hit fan condition )
            //if fan.hero hit then return 1
            return true;
        else{
            return false;}
        //decrease the coins
    }

    public ImageView getImage() {return this.fan;}

    @Override
    public boolean collide(Hero h) {
        h.setDamage(2);
        return false;
    }

    @Override
    public void move() {
        RotateTransition trans = new RotateTransition();
        trans.setAxis(Rotate.Z_AXIS);
        trans.setByAngle(360);
        trans.setCycleCount(Animation.INDEFINITE);
        trans.setDuration(Duration.seconds(5));
        //rotate.setAutoReverse(true);
        trans.setNode(fan);
        trans.play();
    }

    /*
    public Position get_position(){
        return this.position;
    }
     */

}