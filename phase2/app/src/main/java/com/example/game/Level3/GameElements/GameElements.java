package com.example.game.Level3.GameElements;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.game.Level3.Entities.Ball;

import java.util.ArrayList;

public class GameElements {
    public ArrayList<Ball> balls;
    public Ball memoryBall;
    public int showCount;
    public boolean hiddenState;
    public int score;
    public int time;
    public ArrayList<Bitmap> bitmapColours;
    public int lives;
    int point;
    public int level;
    public int numberOfRefreshes;
    public Drawable heart;

    void setBalls(ArrayList<Ball> balls){
        this.balls = balls;
    }

    void setMemoryBall(Ball memoryBall) {
        this.memoryBall = memoryBall;
    }

    void setBitmapColours(ArrayList<Bitmap> bitmapColours) {
        this.bitmapColours = bitmapColours;
    }

    void setShowCount(int showCount) {
        this.showCount = showCount;
    }

    void setHiddenState(boolean hiddenState) {
        this.hiddenState = hiddenState;
    }

    void setScore(int score) {
        this.score = score;
    }

    void setTime(int time) {
        this.time = time;
    }



    void setLives(int lives) {
        this.lives = lives;
    }

    void setPoint(int point) {
        this.point = point;
    }

    void setLevel(int level) {
        this.level = level;
    }

    void setNumberOfRefreshes(int numberOfRefreshes) {
        this.numberOfRefreshes = numberOfRefreshes;
    }

    void setHeart(Drawable heart) {
        this.heart = heart;
    }
}
