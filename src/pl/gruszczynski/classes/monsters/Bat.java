package pl.gruszczynski.classes.monsters;

import pl.gruszczynski.classes.CharacterClass;
import pl.gruszczynski.classes.MonsterClass;

import javax.swing.*;

public class Bat extends MonsterClass {

    public Bat(CharacterClass[] players) {
        super(players);
        this.speed = 1500;
        this.attackAmount = 100;
        this.health = 50;
        this.maxHealth = 50;
        this.image = new ImageIcon("16.png").getImage();
    }
}
