package com.example.game.Level2.Model;

public class GameMode2 implements Algorithms {

    MakeObjects objects;
    private int tries;
    private int score;
    private double percent;

    public GameMode2(MakeObjects objects){
        this.objects = objects;
        this.tries = 0;
        this.score = 0;
        this.percent = 0.0;
    }

    @Override
    public void buttonPressed(float x, float y) {

    }

    @Override
    public void resetGame() {

    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public int getTries() {
        return this.tries;
    }

    @Override
    public double getPercent() {
        return this.percent;
    }
}
