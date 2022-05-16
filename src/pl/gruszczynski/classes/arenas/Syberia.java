package pl.gruszczynski.classes.arenas;

import pl.gruszczynski.classes.ArenaBase;

import javax.swing.*;

public class Syberia extends ArenaBase {
    public Syberia() {
        int[][] sth = {{2*40,0*80},{6*40,0*80},{2*40,4*80},{6*40,4*80},{0*40,2*80},{8*40,2*80},{4*40,2*80}};
        this.wallLocation = sth;
        this.baseImage = new ImageIcon("14.png").getImage();
    }
}
