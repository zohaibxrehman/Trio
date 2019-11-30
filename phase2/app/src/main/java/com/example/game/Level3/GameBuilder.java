package com.example.game.Level3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameBuilder {
    private GameElements gameElements;
    private  SoundFacade soundFacade;
    ArrayList<Bitmap> bitmapColours;
    Drawable heart;
    int time;
    int point;


    GameBuilder(ArrayList<Bitmap> bitmapColours, Drawable heart, int time, int p){
        this.gameElements = new GameElements();
        this.soundFacade = new SoundFacade();
        this.bitmapColours = bitmapColours;
        this.heart = heart;
        this.time = time;
        this.point = p;
    }

    void buildBalls(){
        ArrayList<Ball> balls = new ArrayList<>();
        balls.add(new Ball(bitmapColours.get(0), 100,100));
        balls.add(new Ball(bitmapColours.get(1), 450, 100));
        balls.add(new Ball(bitmapColours.get(2),  800, 100));

        balls.add(new Ball(bitmapColours.get(3), 100,550));
        balls.add(new Ball(bitmapColours.get(4), 450, 550));
        balls.add(new Ball(bitmapColours.get(5), 800, 550));

        balls.add(new Ball(bitmapColours.get(6), 100,1000));
        balls.add(new Ball(bitmapColours.get(7), 450, 1000));
        balls.add(new Ball(bitmapColours.get(8), 800, 1000));
        gameElements.setBalls(balls);
    }

    public void buildMemoryBall() {
        gameElements.setMemoryBall(new Ball(this.bitmapColours.get(ThreadLocalRandom.current().nextInt(0, 9)), 450, 1500));
    }

    public void buildBitmapColours() {
        gameElements.setBitmapColours(this.bitmapColours);
    }

    public void buildGameRefreshElements() {
        gameElements.setShowCount(0);
        gameElements.setNumberOfRefreshes(0);
        gameElements.setHiddenState(false);
    }


    public void buildScore() {
        gameElements.setScore(0);
    }

    public void buildLives() {
        gameElements.setLives(7);
    }

    public void buildHeart() {
        gameElements.setHeart(this.heart);
    }

    public void buildLevel() {
        gameElements.setLevel(1);
    }

    public void buildTime() {
        gameElements.setTime(this.time);
    }

    public void buildPoint() {
        gameElements.setPoint(point);
    }

    GameElements getGameElements(){
        return this.gameElements;
    }


}
