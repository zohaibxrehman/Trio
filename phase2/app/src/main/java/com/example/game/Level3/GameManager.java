package com.example.game.Level3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.example.game.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class GameManager {
    private ArrayList<Ball> balls;
    private Ball memoryBall;
    private int showCount;
    //    private int hiddenCount;
    private boolean hiddenState;
    public static int score;
    private int time;
    private ArrayList<Bitmap> bitmapColours;
    private int lives;
    private int point;
    private Drawable heart;
    private MediaPlayer success;
    private MediaPlayer failure;

    GameManager(ArrayList<Bitmap> bitmapColours, Drawable heart, int time, int p) {
        balls = new ArrayList<>();
        hiddenState = false;
        this.time = time;
        this.point = p;
        showCount = 0;
        score = 0;
        lives = 7;

        this.heart = heart;

        this.bitmapColours = bitmapColours;
        Collections.shuffle(bitmapColours);
        balls.add(new Ball(bitmapColours.get(0), 100,100));
        balls.add(new Ball(bitmapColours.get(1), 450, 100));
        balls.add(new Ball(bitmapColours.get(2),  800, 100));

        balls.add(new Ball(bitmapColours.get(3), 100,550));
        balls.add(new Ball(bitmapColours.get(4), 450, 550));
        balls.add(new Ball(bitmapColours.get(5), 800, 550));

        balls.add(new Ball(bitmapColours.get(6), 100,1000));
        balls.add(new Ball(bitmapColours.get(7), 450, 1000));
        balls.add(new Ball(bitmapColours.get(8), 800, 1000));

        memoryBall = new Ball(bitmapColours.get(ThreadLocalRandom.current().nextInt(0, 9)), 450, 1500);
        memoryBall.hide();
    }

    public void addSuccessSound(MediaPlayer success){
        this.success = success;
    }

    void addFailureSound(MediaPlayer failure){
        this.failure = failure;
    }

    void draw(Canvas canvas) {
        for (Ball ball: balls) {
            if (ball != null)
                ball.draw(canvas);
        }

        memoryBall.draw(canvas);
        Paint scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(100);

        canvas.drawText("Score: " + score, 700, 1800, scorePaint);
        int startX = 25;
        int endX = 175;

        for (int i = 0; i < lives; i++){
            heart.setBounds(startX, 1850, endX, 2000);
            heart.draw(canvas);
            startX += 150;
            endX += 150;
        }
    }

    void update() {
        if (!hiddenState) {
            if (showCount == time) {
                for (Ball b : balls) {
                    b.hide();
                    memoryBall.show();
                }
                hiddenState = true;
            } else if (showCount < time) {
                showCount++;
            }
        }

        if (lives == 0){
            System.exit(0);
        }
    }


    void select(float touchX, float touchY) {
        if (hiddenState) {
            for (Ball b: balls){
                if (b.contains(touchX, touchY) && !b.isTouched()) {
                    b.show();
                    b.setTouched(true);

                    if (b.equals(memoryBall)) {
                        score++;
                        this.success.start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        resetGame();
                    } else {
                        lives--;
                        this.failure.start();
                    }
                }
            }
        }
    }

    private void resetGame(){
//        randomizeColours();
        showCount = 0;
        hiddenState = false;

        Collections.shuffle(bitmapColours);
        for(int i = 0; i < 9; i++) {
            balls.get(i).changeColour(bitmapColours.get(i));
            balls.get(i).show();
            balls.get(i).setTouched(false);
        }
        memoryBall.changeColour(bitmapColours.get(ThreadLocalRandom.current().nextInt(0, 9)));
        memoryBall.hide();
    }
}
