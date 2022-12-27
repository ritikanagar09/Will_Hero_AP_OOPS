package com.example.demo3;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.Serializable;

public class CoinChest extends TreasureChest implements Serializable {
    private int coins;
    private transient ImageView coinchest;
    private String life_status;

    /*
    protected CoinChest(int speed, int x, int y) {
        super(speed,x,y);
        this.coins=50;
        move();
    }

     */

    public CoinChest(double x, double y, int c) {
        super(x,y);
        coinchest = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\coin chest.jpg", 100, 75, false, true));
        coinchest.setX(x);
        coinchest.setY(y);
        coins=c;
        life_status="alive";

        move();
    }

    public ImageView get_image() {
        return this.coinchest;
    }


    transient TranslateTransition trans= new TranslateTransition();

    @Override
    public void move(){
        trans.setDuration(Duration.seconds(0.5));
        //System.out.println(rect.getX());
        trans.setByY(-50);

        trans.setAutoReverse(true);
        trans.setCycleCount(Animation.INDEFINITE);
        //-1 for indefinite
        trans.setNode(coinchest);
        trans.play();
        //add upward move code inside a keyframe

    }

    @Override
    public boolean collide(Hero h){
        if(isAlive()) {
            h.update_coins(this.coins);
            //coinchest.setOpacity(0);
            life_status = "dead";
            coinchest.setImage(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\ChestOpen.png", 100, 75, false, true));
            trans.stop();
        }
        return false;
    }

    public boolean isAlive() {
        return life_status.equals("alive");
    }
}
