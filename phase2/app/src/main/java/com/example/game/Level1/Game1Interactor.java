package com.example.game.Level1;

public class Game1Interactor {


    public void buttonPressed(int touchX, int touchY,GameManager manager) {

        manager.buttonPressed(touchX, touchY);
    }

    interface Buttons{
        void moveToNextGame();

    }

}
