package com.epam;

import java.util.Comparator;

class Checker implements Comparator<Player>{


    public int compare(Player o1, Player o2) {
        if (o1.score > o2.score) return -1;
        if (o1.score < o2.score) return 1;
        return 0;
    }
}
