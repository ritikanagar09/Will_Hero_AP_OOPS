package com.example.demo3;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class RedOrc extends Orc implements Serializable {

    public RedOrc(double x, double y) {
        super(x,y);
        orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\redorc.jpg", 50, 50, false, true));
        orc.setX(x);
        orc.setY(y);
        move();
    }
}
