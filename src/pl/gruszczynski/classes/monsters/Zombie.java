package pl.gruszczynski.classes.monsters;

import pl.gruszczynski.classes.CharacterClass;
import pl.gruszczynski.classes.MonsterClass;

import javax.swing.*;

public class Zombie extends MonsterClass {

    public Zombie(CharacterClass[] players) {
        super(players);
        this.speed = 2500;
        this.attackAmount = 100;
        this.health = 200;
        this.maxHealth = 200;
        this.image = new ImageIcon("15.png").getImage();
    }
}
