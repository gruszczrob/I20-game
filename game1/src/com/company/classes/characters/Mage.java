package com.company.classes.characters;

import com.company.classes.AttackType;
import com.company.classes.CharacterClass;

public class Mage  extends CharacterClass {

    public Mage(String name, int x, int y, int leftKey, int rightKey, int upKey, int downKey, int leftAttackKey, int rightAttackKey) {
        /*this.setLevel(1);
        this.setMaxHealthPoints(1000);
        this.setHealthPoints(1000);
        this.setManaPoints(200);
        this.setMaxManaPoints(200);
        this.setAttackType(AttackType.PHYSICAL);
        this.setAttackAmount(5);
        this.setName(name);*/
        super(name, x, y, leftKey, rightKey, upKey, downKey, leftAttackKey, rightAttackKey);

        this.setX(300);
        this.setY(0);
        this.uploadImage("1.png", "2.png", "3.png");
    }

    public  void left(){
        int newPositionX = this.getX() > 40? this.getX() - 40 :0;
        tryChangePosition(newPositionX, this.getY());
    }
    public  void right(){
        int newPositionX = this.getX() < 320? this.getX() + 40 :320;
        tryChangePosition(newPositionX, this.getY());
    }
    public  void up(){/*
        int newPositionY = this.getY() > 40? this.getY() - 40 :0;
        tryChangePosition(newPositionY, this.getY());*/
    }
    public  void down(){/*
        int newPositionX = 1
        tryChangePosition(newPositionX, this.getY());*/
    }
}
