package org.example;

public class Player {

    private int id;

    private String name;

    private int score;

    private final String color;


    public Player(int id, String name, int score, String color) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.color = color;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
