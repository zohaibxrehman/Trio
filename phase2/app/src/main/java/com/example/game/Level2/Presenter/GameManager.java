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
    private int score;
    private int tries;
    public static double percent;
    private MakeObjects makeObjects;
    private int gameMode;
    private Algorithms algorithm;

    public GameManager(int height, int width, int gameMode){
        gridHeight = height;
        gridWidth = width;
        int difficulty = 4;
        this.makeObjects = new MakeObjects(difficulty);
        this.gameMode = gameMode;
        setGameMode(gameMode);
        score = algorithm.getScore();
        tries = algorithm.getTries();
        percent = algorithm.getPercent();
    }

    private void setGameMode(int gameMode){
        System.out.println("hi");
        if (gameMode == 1){
            this.algorithm = new GameMode1(this.makeObjects);
        } else if (gameMode == 2){
            this.algorithm = new GameMode2(this.makeObjects);
        } else if (gameMode == 3){
            this.algorithm = new GameMode3(this.makeObjects);
        }
    }

    @SuppressLint("DefaultLocale")
    public void draw(Canvas canvas) {
        Paint scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(50);
        Paint messagePaint = new Paint();
        messagePaint.setColor(Color.WHITE);
        DrawObjects drawObjects = new DrawObjects();
        canvas.drawColor(Color.BLACK);
        drawObjects.draw(canvas, makeObjects);
        score = algorithm.getScore();
        canvas.drawText("Total Correct: " + score, 100, 1950, scorePaint);
        percent = algorithm.getPercent();
        canvas.drawText("Success Rate: " + String.format("%.0f", percent) + "%", 100,1900, scorePaint);
    }

    public void buttonPressed(float x, float y) {

        algorithm.buttonPressed(x, y);
    }

}
