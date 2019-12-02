package com.example.game.Level2.Model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class GameMode2 implements Algorithms {

    private MakeObjects objects;
    private int score;
    private boolean gameOver;
    private int targets;
    private int lives;
    private List<LeftBall> pressed;
    private boolean undo;

    public GameMode2(MakeObjects objects, int lives) {
        this.objects = objects;
        this.score = 0;
        this.gameOver = false;
        targets = 0;
        this.lives = lives;
        this.pressed = new ArrayList<>();
        this.undo = false;
    }

    @Override
    public void buttonPressed(float x, float y) {
        if (!this.gameOver && lives > 0) {
            for (LeftBall b : objects.getLeft()) {
                if (b.contains(x, y) && !b.getTouched()) {
                    b.setTouched();
                    if (!b.getIsTarget()) {
                        targets++;
                        score++;
                        b.setColor(Color.GREEN);
                        addDelay();
                    } else {
                        lives--;
                        b.setColor(Color.RED);
                        addDelay();
                    }
                    if (b.getIsTarget() | b.getPair().getIsTarget()) {
                        addDelay();
                        resetGame();
                    }
                }
                if (score == 14) {
                    this.gameOver = true;
                }
                if (targets == 3) {
                    addDelay();
                    resetGame();
                }
            }
        }
    }

    private void addDelay() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
        this.gameOver = false;
        this.lives = 1;
        LeftBall b = this.pressed.get(pressed.size() - 1);
        b.undo();
    }

    @Override
    public int getLives() {
        return this.lives;
    }

    @Override
    public void resetGame() {
        targets = 0;
        objects.resetGame();
    }

    @Override
    public String getScore() {
        return Integer.toString(score);
    }

    @Override
    public boolean getGameOver() {
        return this.gameOver;
    }


    @Override
    public boolean getUndo() {
        return this.undo;
    }

    @Override
    public int getGameScore() {
        return this.score;
    }
}
