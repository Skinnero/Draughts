package org.example;

public class Player {

    private final int id;

    private final String name;

    private int score;

    private final String color;


    public Player(int id, String name, int score, String color) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.color = color;
    }

    // TODO: (DOMINIK) IS GAME WON FUNCTION

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
