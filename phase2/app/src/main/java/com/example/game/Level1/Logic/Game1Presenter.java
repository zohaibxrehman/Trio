package com.example.game.Level1.Logic;

import android.graphics.Canvas;

import com.example.game.Level1.Entities.GameManager;

public class Game1Presenter implements Game1Interactor.Buttons {
    private Game1Interactor game1Interactor = new Game1Interactor();
   // GameManager manager;
    private Game1View game1View;


    public Game1Presenter(Game1View game1View){
        this.game1View = game1View;

    }


//    public Game1Presenter(GameManager manager){
//        this.manager = manager;
//        this.game1Interactor = new Game1Interactor();
//    }


    public void ballMove(float touchX, GameManager manager) {

        game1Interactor.ballMove(touchX, manager);


    }

    @Override
    public void moveToNextGame() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        game1View.moveToNextGame();
    }

    public void update(GameManager manager) {
        game1Interactor.update(manager);

    }

    public boolean draw(Canvas canvas, GameManager gameManager) {
       boolean nextGame = game1Interactor.draw(canvas, gameManager);
       if (nextGame){
           moveToNextGame();
       }
        return game1Interactor.checker;
    }

}
