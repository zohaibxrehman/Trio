package com.example.game.Level2.Model;

public interface Algorithms{
    void buttonPressed(float x, float y);

    void resetGame();

    int getScore();

    int getTries();

    double getPercent();

    boolean getGameOver();
}
