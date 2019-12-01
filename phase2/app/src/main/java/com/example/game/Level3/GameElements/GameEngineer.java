package com.example.game.Level3.GameElements;

public class GameEngineer {
    private GameBuilder gameBuilder;
    public GameEngineer(GameBuilder gameBuilder){
        this.gameBuilder = gameBuilder;  // Dependency Injection
    }

    public GameElements getGameElements(){
        return this.gameBuilder.getGameElements();
    }

    public void constructGame(){
        this.gameBuilder.buildBalls();
        this.gameBuilder.buildMemoryBall();
        this.gameBuilder.buildBitmapColours();

        this.gameBuilder.buildGameRefreshElements();

        this.gameBuilder.buildScore();
        this.gameBuilder.buildLives();
        this.gameBuilder.buildHeart();
        this.gameBuilder.buildLevel();

        this.gameBuilder.buildTime();
    }
}
