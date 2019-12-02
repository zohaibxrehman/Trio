package com.example.game.Level2.Presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.game.Level2.Model.Algorithms;
import com.example.game.Level2.Model.GameMode1;
import com.example.game.Level2.Model.GameMode2;
import com.example.game.Level2.Model.GameMode3;
import com.example.game.Level2.Model.MakeObjects;
import com.example.game.Level2.View.Level2Activity;

public class GameManager {
    private String score;
    private MakeObjects makeObjects;
    private int gameMode;
    private Algorithms algorithm;
    private int tries;
    private DrawObjects drawObjects;

    GameManager(int gameMode, boolean hard) {
        int difficulty = 4;
        this.makeObjects = new MakeObjects(difficulty);
        this.gameMode = gameMode;
        setTries(hard);
        setGameMode();
        score = algorithm.getScore();
        drawObjects = new DrawObjects();
    }

    private void setTries(boolean hard) {
        if (hard) {
            this.tries = 5;
        } else {
            this.tries = 7;
        }
    }

    private void setGameMode() {
        if (gameMode == 1) {
            this.algorithm = new GameMode1(this.makeObjects, tries);
        } else if (gameMode == 2) {
            this.algorithm = new GameMode2(this.makeObjects, tries);
        } else if (gameMode == 3) {
            this.algorithm = new GameMode3(this.makeObjects, tries);
        }
    }

    @SuppressLint("DefaultLocale")
    public void draw(Canvas canvas) {
        int lives = algorithm.getLives();
        boolean gameOver = algorithm.getGameOver();
        if (gameOver) {
            Paint winPaint = new Paint();
            winPaint.setColor(Color.GREEN);
            winPaint.setTextSize(100);
            canvas.drawText("YOU WIN", 300, 1000, winPaint);
        } else if (lives <= 0) {
            Paint losePaint = new Paint();
            losePaint.setColor(Color.RED);
            losePaint.setTextSize(100);
            canvas.drawText("YOU LOSE", 300, 1000, losePaint);
            if (!algorithm.getUndo()){
                drawObjects.undoButton(canvas, makeObjects);
            }
        } else {
            Paint scorePaint = new Paint();
            scorePaint.setColor(Color.WHITE);
            scorePaint.setTextSize(50);
            canvas.drawColor(Color.BLACK);
            drawObjects.draw(canvas, makeObjects);
            score = algorithm.getScore();
            canvas.drawText("Score: " + score, 100, 1950, scorePaint);
        }

    }

    void buttonPressed(float x, float y) {
        algorithm.buttonPressed(x, y);
    }

}

