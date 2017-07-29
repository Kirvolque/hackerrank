package com.epam;

import java.util.Comparator;

public class Player{
    String name;
    Integer score;

    public Player (String name, int score){
        this.name = name;
        this.score = score;
    }

    public int compare(Player o1, Player o2) {
        if (o1.score > o2.score) return -1;
        if (o1.score < o2.score) return 1;
        return o1.name.compareToIgnoreCase(o2.name);
    }
}
