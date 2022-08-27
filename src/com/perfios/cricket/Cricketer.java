package com.perfios.cricket;

import java.util.*;
import java.util.stream.Collectors;
class PlayerNameComparator implements Comparator<Cricketer>{

    @Override
    public int compare(Cricketer player1, Cricketer player2) {
        return player1.getName().compareTo(player2.getName());
    }
}

class PlayerAverageScoreComparator implements Comparator<Cricketer>{

    @Override
    public int compare(Cricketer player1, Cricketer player2) {
        return (int) (player1.getAverage() - player2.getAverage());
    }
}

public class Cricketer implements Comparable<Cricketer>{
    private String name;
    private int matchesPlayed;
    private int runs;
    private int wicket;
    private int duck;
    private int playerType;


    public float average;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public float getAverage(){
        return average;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWicket() {
        return wicket;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }

    public int getDuck() {
        return duck;
    }

    public void setDuck(int duck) {
        this.duck = duck;
    }

    public int getPlayerType() {
        return playerType;
    }

    public void setPlayerType(int playerType) {
        this.playerType = playerType;
    }

    @Override
    public int compareTo(Cricketer o){
        return (int) (this.getAverage() -o.getAverage());
    }


}
