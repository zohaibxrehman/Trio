package com.example.game.Level2.Model;

public class GameMode3 implements Algorithms {

    MakeObjects objects;
    private int tries;
    private int score;
    private double percent;

    public GameMode3(MakeObjects objects){
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
        return getScore();
    }

    @Override
    public int getTries() {
        return getTries();
    }

    @Override
    public double getPercent() {
        return getPercent();
    }
}
