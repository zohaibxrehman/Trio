package com.example.game.Level2.Model;

public class GameMode3 implements Algorithms {

    MakeObjects objects;
    private int tries;
    private int score;
    private double percent;
    private boolean gameOver;

    public GameMode3(MakeObjects objects){
        this.objects = objects;
        this.tries = 0;
        this.score = 0;
        this.percent = 0.0;
        this.gameOver = false;
    }

    @Override
    public void buttonPressed(float x, float y) {

    }

    @Override
    public int getTries() {
        return this.tries;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public double getPercent() {
        return this.percent;
    }

    @Override
    public boolean getGameOver() {
        return this.gameOver;
    }

    @Override
    public void resetGame() {
        objects.resetGame();
    }
}
