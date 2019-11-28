package com.example.game.Level2;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Pair;


import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static int gridHeight;
    private static int gridWidth;
    public static int score;
    private static int tries;
    public static double percent;
    MakeObjects makeObjects;

    GameManager(int height, int width){
        gridHeight = height;
        gridWidth = width;
        int difficulty = 4;
        score = 0;
        tries = 0;
        percent = 0.0;
        this.makeObjects = new MakeObjects(difficulty);

    }

    @SuppressLint("DefaultLocale")
    void draw(Canvas canvas) {
        Paint scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(50);
        Paint messagePaint = new Paint();
        messagePaint.setColor(Color.WHITE);
        canvas.drawColor(Color.BLACK);
        for (Line line: makeObjects.getLines()){
            line.draw(canvas);
        }
        for (RightBall ball: makeObjects.getRight()) {
            ball.draw(canvas);
        }
        for (LeftBall ball: makeObjects.getLeft()) {
            ball.draw(canvas);
        }
        canvas.drawText("Total Correct: " + score, 100, 1950, scorePaint);
        if (tries == 0){
            percent = 0;
        } else{
            percent = (score * 1.0) / (tries * 1.0) * 100;
        }
        canvas.drawText("Success Rate: " + String.format("%.0f", percent) + "%", 100,1900, scorePaint);
    }

    void buttonPressed(float x, float y) {
        for (LeftBall b: makeObjects.getLeft()){
            if (b.contains(x, y) && !b.getTouched()) {
                tries++;
                b.setTouched();
                b.setColor();
                if(b.getIsTarget() | b.getPair().getIsTarget()){
                    score++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resetGame();
                }
            }
        }
    }

    private void resetGame(){
        makeObjects.resetGame();
    }

}
