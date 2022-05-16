package pl.gruszczynski.Menu;

import pl.gruszczynski.Team;
import pl.gruszczynski.classes.ArenaBase;
import pl.gruszczynski.classes.CharacterClass;
import pl.gruszczynski.classes.arenas.Castle;
import pl.gruszczynski.classes.arenas.Syberia;
import pl.gruszczynski.classes.characters.Archer;
import pl.gruszczynski.classes.characters.Healer;
import pl.gruszczynski.classes.characters.Mage;
import pl.gruszczynski.classes.characters.Warrior;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Menu extends JPanel {

    private Team team;
    public String[] PlayersNumberSolo = {"1", "2", "3", "4"};
    private String[] PlayersNumberTeam = {"4"};
    private String[] mapNames = {"winter", "castle"};
    private String[] Modes = {"Solo Deadmatch", "Team Deadmatch"};
    private String[] Classes = {"Archer", "Healer", "Mage", "Warrior"};
    public MenuWindow frame;
    public String ModeChosen;
    public String TeamChosen;
    public Integer TeamChosenInt;
    public String MapChosen;
    public String ClasseChosen;
    public JComboBox TeamChose;
    public Team teamfin;
    public Integer jetplay = 0;
    int[] x = {0, 0, 320, 320};
    int[] y = {0, 320, 0, 320};
    int[] left = {KeyEvent.VK_A, KeyEvent.VK_H, KeyEvent.VK_LEFT, KeyEvent.VK_NUMPAD1};
    int[] right = {KeyEvent.VK_D, KeyEvent.VK_K, KeyEvent.VK_RIGHT, KeyEvent.VK_NUMPAD3};
    int[] up = {KeyEvent.VK_W, KeyEvent.VK_U, KeyEvent.VK_UP, KeyEvent.VK_NUMPAD5};
    int[] down = {KeyEvent.VK_S, KeyEvent.VK_J, KeyEvent.VK_DOWN, KeyEvent.VK_NUMPAD2};
    int[] lattac = {KeyEvent.VK_Q, KeyEvent.VK_Y, KeyEvent.VK_DELETE, KeyEvent.VK_NUMPAD4};
    int[] rattac = {KeyEvent.VK_E, KeyEvent.VK_I, KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_NUMPAD6};
    int[] ability = {KeyEvent.VK_R, KeyEvent.VK_O, KeyEvent.VK_SHIFT, KeyEvent.VK_NUMPAD9};
    ArrayList<Warrior> wartab = new ArrayList<Warrior>();
    ArrayList<Mage> magtab = new ArrayList<Mage>();
    ArrayList<Healer> heltab = new ArrayList<Healer>();
    ArrayList<Archer> arctab = new ArrayList<Archer>();


    int i = 0;

    public Menu(MenuWindow frame) {
        this.frame = frame;
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //Menu
        g.drawString("MENU", 50, 10);
        //Select map
        g.drawString("Map: ", 20, 50);
        final JComboBox mapchose = new JComboBox(mapNames);
        mapchose.setSelectedIndex(0);
        mapchose.setBounds(75, 40, 150, 20);

        //select mode
        g.drawString("Mode: ", 20, 100);
        final JComboBox Modechose = new JComboBox(Modes);
        Modechose.setSelectedIndex(0);
        Modechose.setBounds(75, 100, 150, 20);

        JButton Modeb = new JButton("Submit your choice");
        Modeb.setBounds(75, 130, 150, 20);
        frame.add(Modeb);
        Modeb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(Modeb);
                SwingUtilities.updateComponentTreeUI(frame);
                MapChosen = (String) mapchose.getItemAt(mapchose.getSelectedIndex());
                ModeChosen = (String) Modechose.getItemAt(Modechose.getSelectedIndex());
                System.out.println(ModeChosen);


                //select count of players in game
                g.drawString("Players: ", 20, 170);
                final JComboBox TeamChose = new JComboBox((ModeChosen == "Team Deadmatch") ? PlayersNumberTeam : PlayersNumberSolo);
                frame.add(TeamChose);
                TeamChose.setBounds(75, 170, 150, 20);
                JButton Teamb = new JButton("Submit your choice");
                Teamb.setBounds(75, 210, 150, 20);
                frame.add(Teamb);

                Teamb.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TeamChosen = (String) TeamChose.getItemAt(TeamChose.getSelectedIndex());
                        ModeChosen = String.valueOf(Teamb);
                        frame.remove(Teamb);
                        SwingUtilities.updateComponentTreeUI(frame);
                        i = 0;
                        TeamChosenInt = Integer.parseInt(TeamChosen);
                        System.out.println(TeamChosenInt);
                        //ALL OF THE PLAYERS WRITE THEIR NICKNAME AND SELECT CLASSES
                        while (TeamChosenInt > i) {
                            g.drawString("Player " + (i + 1) + ". ", 20, 240 + i * 30);

                            final JTextField Player = new JTextField("Player " + (i + 1) + ".");
                            Player.setBounds(75, 240 + i * 30, 150, 20);
                            frame.add(Player);
                            g.drawString("Class: ", 250, 240 + i * 30);

                            final JComboBox ClasseChoice = new JComboBox(Classes);
                            frame.add(ClasseChoice);
                            ClasseChoice.setSelectedIndex(0);
                            ClasseChoice.setBounds(300, 240 + i * 30, 100, 20);
                            frame.add(ClasseChoice);
                            JButton Submitt = new JButton("Submit your choice");
                            Submitt.setBounds(450, 240 + i * 30, 150, 20);
                            frame.add(Submitt);

                            Submitt.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    ClasseChosen = (String) ClasseChoice.getItemAt(ClasseChoice.getSelectedIndex());
                                    String play = Player.getText();
                                    switch (ClasseChosen) {
                                        case "Warrior":
                                            System.out.println(play + "Warrior");
                                            Warrior warrior = new Warrior(play, x[jetplay], y[jetplay], left[jetplay], right[jetplay], up[jetplay], down[jetplay], lattac[jetplay], rattac[jetplay], 0);
                                            wartab.add(warrior);
                                            System.out.println("teamtab" + wartab);
                                            jetplay++;
                                            frame.remove(Submitt);
                                            SwingUtilities.updateComponentTreeUI(frame);
                                            break;

                                        case "Mage":
                                            System.out.println(play + "Mage");
                                            Mage mage = new Mage(play, x[jetplay], y[jetplay], left[jetplay], right[jetplay], up[jetplay], down[jetplay], lattac[jetplay], rattac[jetplay], 0);
                                            magtab.add(mage);
                                            System.out.println("teamtab" + magtab);
                                            jetplay++;
                                            frame.remove(Submitt);
                                            SwingUtilities.updateComponentTreeUI(frame);
                                            break;

                                        case "Archer":
                                            System.out.println(play + "Archer");
                                            Archer archer = new Archer(play, x[jetplay], y[jetplay], left[jetplay], right[jetplay], up[jetplay], down[jetplay], lattac[jetplay], rattac[jetplay], 0);
                                            arctab.add(archer);
                                            System.out.println("teamtab" + arctab);
                                            jetplay++;
                                            frame.remove(Submitt);
                                            SwingUtilities.updateComponentTreeUI(frame);
                                            break;

                                        case "Healer":
                                            System.out.println(play + "Healer");
                                            Healer healer = new Healer(play, x[jetplay], y[jetplay], left[jetplay], right[jetplay], up[jetplay], down[jetplay], lattac[jetplay], rattac[jetplay], ability[jetplay]);
                                            heltab.add(healer);
                                            System.out.println("teamtab" + heltab);
                                            jetplay++;
                                            frame.remove(Submitt);
                                            SwingUtilities.updateComponentTreeUI(frame);
                                            break;
                                    }
                                }
                            });
                            i++;
                        }


                        //Start
                        JButton start = new JButton("Start");
                        start.setBounds(50, 270 + (i * 30), 100, 20);
                        frame.add(start);
                        start.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Team team = null;
                                ///////////////////////////////////////////////////
                                team = new Team (
                                        new Warrior("Aragorn", 0, 0, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_Q, KeyEvent.VK_E, 0),
                                        new Mage("Gendolf", 0, 320, KeyEvent.VK_H, KeyEvent.VK_K, KeyEvent.VK_U, KeyEvent.VK_J, KeyEvent.VK_Y, KeyEvent.VK_I, 0),
                                        new Archer("Legolas", 320, 0, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_DELETE, KeyEvent.VK_PAGE_DOWN, 0),
                                        new Healer("Radagast", 320, 320, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD9)
                                );
 //////////////////////////////////////////////////////////////////////////////////
                                System.out.println(team);
                                ArenaBase map = null;
                                switch (MapChosen){
                                    case "Winter":
                                        map = new Syberia();
                                        break;
                                    case "Castle":
                                        map = new Castle();
                                        break;
                                }
                                System.out.println(team);
                                if (team.enterArena(map)) {
                                    team.setArena(map);
                                    team.start();
                                    for (int[] wall : map.getWallLocation()) {
                                        CharacterClass.occupiedCells[wall[0]][wall[1]] = 5;
                                    }
                                } else {
                                    System.out.println("Game over");
                                }
                                frame.dispose();
                            }
                        });
                    }
                });
            }
        });

        frame.add(mapchose);
        frame.add(Modechose);


        frame.setLayout(null);
        frame.setVisible(true);

    }
}



