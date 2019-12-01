package com.example.game.Level3.GameElements;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.game.Level3.Entities.Ball;
import com.example.game.Level3.Sound.SoundFacade;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameBuilder {
    private GameElements gameElements;
    private ArrayList<Bitmap> bitmapColours;
    private Drawable heart;
    int time;
    int point;


    public GameBuilder(ArrayList<Bitmap> bitmapColours, Drawable heart, int time){
        this.gameElements = new GameElements();
        this.bitmapColours = bitmapColours;
        this.heart = heart;
        this.time = time;

    }

    void buildBalls(){
        ArrayList<Ball> balls = new ArrayList<>();
        balls.add(new Ball(bitmapColours.get(0), 100,200));
        balls.add(new Ball(bitmapColours.get(1), 450, 200));
        balls.add(new Ball(bitmapColours.get(2),  800, 200));

        balls.add(new Ball(bitmapColours.get(3), 100,650));
        balls.add(new Ball(bitmapColours.get(4), 450, 650));
        balls.add(new Ball(bitmapColours.get(5), 800, 650));

        balls.add(new Ball(bitmapColours.get(6), 100,1100));
        balls.add(new Ball(bitmapColours.get(7), 450, 1100));
        balls.add(new Ball(bitmapColours.get(8), 800, 1100));
        gameElements.setBalls(balls);
    }

    void buildMemoryBall() {
        gameElements.setMemoryBall(new Ball(this.bitmapColours.get(ThreadLocalRandom.current().nextInt(0, 9)), 450, 1500));
        this.gameElements.memoryBall.hide();
    }

    void buildBitmapColours() {
        gameElements.setBitmapColours(this.bitmapColours);
    }

    void buildGameRefreshElements() {
        gameElements.setShowCount(0);
        gameElements.setNumberOfRefreshes(0);
        gameElements.setHiddenState(false);
    }


    void buildScore() {
        gameElements.setScore(0);
    }

    void buildLives() {
        gameElements.setLives(7);
    }

    void buildHeart() {
        gameElements.setHeart(this.heart);
    }

    void buildLevel() {
        gameElements.setLevel(1);
    }

    void buildTime() {
        gameElements.setTime(this.time);
    }

    GameElements getGameElements(){
        return this.gameElements;
    }


}
