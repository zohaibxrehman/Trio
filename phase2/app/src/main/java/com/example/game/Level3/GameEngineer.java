package com.example.game.Level3;

public class GameEngineer {
    private GameBuilder gameBuilder;
    GameEngineer(GameBuilder gameBuilder){
        this.gameBuilder = gameBuilder;  // Dependency Injection
    }

    GameElements getGameElements(){
        return this.gameBuilder.getGameElements();
    }

    void constructGame(){
        this.gameBuilder.buildBalls();
        this.gameBuilder.buildMemoryBall();
        this.gameBuilder.buildBitmapColours();

        this.gameBuilder.buildGameRefreshElements();

        this.gameBuilder.buildScore();
        this.gameBuilder.buildLives();
        this.gameBuilder.buildHeart();
        this.gameBuilder.buildLevel();

        this.gameBuilder.buildPoint();
        this.gameBuilder.buildTime();
    }
}
