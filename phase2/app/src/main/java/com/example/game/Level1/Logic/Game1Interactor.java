package com.example.game.Level1.Logic;

import android.graphics.Canvas;

import com.example.game.Level1.Entities.GameManager;

public class Game1Interactor {


    public void buttonPressed(int touchX, int touchY, GameManager manager) {

        manager.buttonPressed(touchX, touchY);
    }

    public void update(GameManager manager) {
        manager.update();

    }

    public boolean draw(Canvas canvas, GameManager gameManager) {
        return gameManager.draw(canvas);
    }

    interface Buttons{
        void moveToNextGame();

    }

}
