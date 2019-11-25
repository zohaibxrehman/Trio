package com.example.game.Level1;

import android.graphics.Canvas;

public class Game1Interactor {


    public void buttonPressed(int touchX, int touchY,GameManager manager) {

        manager.buttonPressed(touchX, touchY);
    }

    public void update(GameManager manager) {
        manager.update();

    }

    public void draw(Canvas canvas, GameManager gameManager) {
        gameManager.draw(canvas);
    }

    interface Buttons{
        void moveToNextGame();

    }

}
