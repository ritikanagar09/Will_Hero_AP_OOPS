package com.example.demo3;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Orc extends Game_Objects implements Movable{
    protected int no_of_lives;
    protected int winning_points;
    protected transient ImageView orc;
    protected String life_status;

    public Orc(double x,double y) {
        super(x,y);
        no_of_lives=10;
        winning_points=25;
        life_status="alive";
    }

    public final boolean collide(Hero h) {
        if(life_status.equals("alive")) {
            if(!h.has_weapon()) this.no_of_lives--;
            else this.no_of_lives-=h.get_damage();
            if (this.no_of_lives == 0) {
                life_status = "dead";
                orc.setOpacity(0);
                h.update_coins(winning_points);
            }
        }
        return false;
    }
    public final boolean isAlive() {
        return life_status.equals("alive");
    }
    public final ImageView get_image() {
        return this.orc;
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
        trans.setNode(orc);
        trans.play();
    }
}