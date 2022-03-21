package com.company;

import com.company.classes.CharacterClass;
import com.company.classes.arenas.Syberia;
import com.company.classes.characters.Archer;
import com.company.classes.characters.Healer;
import com.company.classes.characters.Mage;
import com.company.classes.characters.Warrior;

import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {
        //Warrior war1 = new Warrior("NAme");
        //war1.info();

        Team team = new Team (
            new Warrior("Aragorn", 0, 0, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_Q, KeyEvent.VK_E),
            new Archer("Gendolf", 0, 0, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_1, KeyEvent.VK_2)
        );
        team.info();
        Syberia arena1 = new Syberia();
        if (team.enterArena(arena1)) {
            team.setArena(arena1);
            team.runArena();
        } else {
            System.out.println("Game over");
        }
    }
}
