package com.example.game.Level2.Presenter;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.game.Level2.Model.Algorithms;
import com.example.game.Level2.Model.GameMode1;
import com.example.game.Level2.Model.GameMode2;
import com.example.game.Level2.Model.GameMode3;
import com.example.game.Level2.Model.MakeObjects;

public class GameManager {
    private static int gridHeight;
    private static int gridWidth;
    private String score;
    private MakeObjects makeObjects;
    private int gameMode;
    private Algorithms algorithm;
    private int tries;

    GameManager(int height, int width, int gameMode){
        gridHeight = height;
        gridWidth = width;
        int difficulty = 4;
        this.makeObjects = new MakeObjects(difficulty);
        this.gameMode = gameMode;
        setGameMode(gameMode);
        score = algorithm.getScore();
        this.tries = 10;
    }

    private void setGameMode(int gameMode){
        if (gameMode == 1){
            this.algorithm = new GameMode1(this.makeObjects, tries);
        } else if (gameMode == 2){
            this.algorithm = new GameMode2(this.makeObjects, tries);
        } else if (gameMode == 3){
            this.algorithm = new GameMode3(this.makeObjects, tries);
        }
    }

    @SuppressLint("DefaultLocale")
    public void draw(Canvas canvas) {
        Paint scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(50);
        DrawObjects drawObjects = new DrawObjects();
        canvas.drawColor(Color.BLACK);
        drawObjects.draw(canvas, makeObjects);
        score = algorithm.getScore();
        canvas.drawText("Score: " + score, 100, 1950, scorePaint);
    }

    void buttonPressed(float x, float y) {
        algorithm.buttonPressed(x, y);
    }

}
