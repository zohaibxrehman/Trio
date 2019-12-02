package com.example.game.Level2.Model;

public interface Algorithms{
    void buttonPressed(float x, float y);

    void resetGame();

    String getScore();

    int getLives();

    void undo();

    boolean getGameOver();

    boolean getUndo();

    int getGameScore();
}
