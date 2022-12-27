package com.example.demo3;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class BossOrc extends Orc implements Serializable {
    public BossOrc(double x, double y) {
        super(x,y);
        orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\OrcBoss.png", 200, 200, false, true));
        orc.setX(x);
        orc.setY(y);
        no_of_lives=30;
        winning_points=50;
        move();
    }
}
