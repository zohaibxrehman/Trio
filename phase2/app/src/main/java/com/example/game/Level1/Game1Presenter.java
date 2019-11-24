package com.example.game.Level1;

public class Game1Presenter implements Game1Interactor.Buttons {
    Game1Interactor game1Interactor = new Game1Interactor();
    GameManager manager;
    Game1View game1View;
    public Game1Presenter(){}

    public Game1Presenter(Game1View game1View){
        this.game1View = game1View;
    }


//    public Game1Presenter(GameManager manager){
//        this.manager = manager;
//        this.game1Interactor = new Game1Interactor();
//    }


    public void checkButtonPressed(int touchX, int touchY,GameManager manager) {

        game1Interactor.buttonPressed(touchX,touchY,manager);


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
}
