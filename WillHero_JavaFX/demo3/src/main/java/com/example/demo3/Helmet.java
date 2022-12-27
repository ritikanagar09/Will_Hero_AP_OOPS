package com.example.demo3;

import java.io.Serializable;

public class Helmet implements Serializable {
    private Weapon Weapon1;
    private Weapon Weapon2;
    private Weapon weapon_in_use;

    public Helmet() {
        Weapon1=null;
        Weapon2=null;
        weapon_in_use=null;
    }

    public Weapon get_weapon_in_use() {
        return this.weapon_in_use;
    }

    public void set_weapon_in_use(Weapon w) {
        this.weapon_in_use = w;
    }
    public int get_damage() {return this.weapon_in_use.get_damage();}
}
