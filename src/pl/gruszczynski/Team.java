package pl.gruszczynski;

import pl.gruszczynski.classes.ArenaBase;
import pl.gruszczynski.classes.CharacterClass;
import pl.gruszczynski.classes.MonsterClass;
import pl.gruszczynski.classes.monsters.Bat;
import pl.gruszczynski.classes.monsters.Zombie;

public class Team {
    private CharacterClass[] teamMembers;
    public static int i = 0;
    private ArenaBase arena;

    public void setArena(ArenaBase arena) {
        this.arena = arena;
    }

    public Team(CharacterClass... members) {
        teamMembers = new CharacterClass[members.length];

        for (int i = 0; i < teamMembers.length; i++) {
            teamMembers[i] = members[i];
        }
    }

    public CharacterClass[] getTeamMembers() {
        return teamMembers;
    }

    public void info(){
        for(CharacterClass teamMembers : teamMembers){
            teamMembers.info();
        }
    }

    public boolean enterArena(ArenaBase arena1) {
        return arena1.open(this);
    }

    public void start() {
        MonsterClass[] monsters = new MonsterClass[999];
        monsters[i] = new Bat(this.teamMembers);
        MainWindow mw = new MainWindow(375, 438, this, monsters);
        this.spawnMonsters();
    }

    public void spawnMonsters() {
        Team thisTeam = this;
        if (MonsterClass.currentMonsters <= 3) {
            i++;
            GameField.monsters[i] = new Zombie(this.teamMembers);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            thisTeam.spawnMonsters();
                        }
                    }, 5000
            );
        }
    }

    public ArenaBase getArena() {
        return arena;
    }
}
