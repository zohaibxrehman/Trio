package com.example.game.Level3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class GameElements {
    ArrayList<Ball> balls;
    Ball memoryBall;
    int showCount;
    boolean hiddenState;
    int score;
    int time;
    ArrayList<Bitmap> bitmapColours;
    int lives;
    int point;
    int level;
    int numberOfRefreshes;
    Drawable heart;

    void setBalls(ArrayList<Ball> balls){
        this.balls = balls;
    }

    public void setMemoryBall(Ball memoryBall) {
        this.memoryBall = memoryBall;
    }

    public void setBitmapColours(ArrayList<Bitmap> bitmapColours) {
        this.bitmapColours = bitmapColours;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
    }

    public void setHiddenState(boolean hiddenState) {
        this.hiddenState = hiddenState;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTime(int time) {
        this.time = time;
    }



    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setNumberOfRefreshes(int numberOfRefreshes) {
        this.numberOfRefreshes = numberOfRefreshes;
    }

    public void setHeart(Drawable heart) {
        this.heart = heart;
    }
}
