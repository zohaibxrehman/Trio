package com.example.game.Level3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class GameManager implements ValueEventListener{
//    private ArrayList<Ball> balls;
//    private Ball memoryBall;
//    private int showTime;
//    private boolean hiddenState;
//    public int score;
//    private int time;
//    private ArrayList<Bitmap> bitmapColours;
//    private int lives;
//    private int point;
//    private int level;
//    private int numberOfRefreshes;
//    private Drawable heart;
    private MediaPlayer success;
    private MediaPlayer failure;
    private MediaPlayer whooshSound;
    public String name;
    private DatabaseReference reference;
    private GameElements gameElements;

    GameManager(ArrayList<Bitmap> bitmapColours, Drawable heart, int time, int p, String name) {
        GameBuilder gameBuilder = new GameBuilder(bitmapColours, heart, time, p);
        GameEngineer gameEngineer = new GameEngineer(gameBuilder);
        gameEngineer.constructGame();
        this.gameElements = gameEngineer.getGameElements();
//        SoundFacade soundFacade = gameEngineer.getSoundFacade();

//        memoryBall = new Ball(bitmapColours.get(ThreadLocalRandom.current().nextInt(0, 9)), 450, 1500);
//        memoryBall.hide();
//
//        balls = new ArrayList<>();
//        balls.add(new Ball(bitmapColours.get(0), 100,100));
//        balls.add(new Ball(bitmapColours.get(1), 450, 100));
//        balls.add(new Ball(bitmapColours.get(2),  800, 100));
//
//        balls.add(new Ball(bitmapColours.get(3), 100,550));
//        balls.add(new Ball(bitmapColours.get(4), 450, 550));
//        balls.add(new Ball(bitmapColours.get(5), 800, 550));
//
//        balls.add(new Ball(bitmapColours.get(6), 100,1000));
//        balls.add(new Ball(bitmapColours.get(7), 450, 1000));
//        balls.add(new Ball(bitmapColours.get(8), 800, 1000));
//
//        this.bitmapColours = bitmapColours;
//
//
//        hiddenState = false;
//        showTime = 0;
//        this.numberOfRefreshes = 0;
//
//
//        this.heart = heart;
//        score = 0;
//        lives = 7;
//        this.level = 1;
//
//
//        this.time = time;
//        this.point = p;
//
        this.name = name;
//
        this.reference = FirebaseDatabase.getInstance().getReference().child(name);
        Collections.shuffle(gameElements.bitmapColours);
    }

    void addSuccessSound(MediaPlayer success){
        this.success = success;
    }

    void addFailureSound(MediaPlayer failure){
        this.failure = failure;
    }

    void  addWhooshSound(MediaPlayer whoosh){
        this.whooshSound = whoosh;
    }

    void draw(Canvas canvas) {
        for (Ball ball: gameElements.balls) {
            if (ball != null)
                ball.draw(canvas);
        }

        gameElements.memoryBall.draw(canvas);
        Paint scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(100);
        canvas.drawText("Score: " + gameElements.score, 700, 1800, scorePaint);

        Paint levelPaint = new Paint();
        levelPaint.setColor(Color.WHITE);
        levelPaint.setTextSize(100);
        canvas.drawText("Level: " + gameElements.level, 700, 1600, levelPaint);


        int startX = 25;
        int endX = 175;
        for (int i = 0; i < gameElements.lives; i++){
            gameElements.heart.setBounds(startX, 1850, endX, 2000);
            gameElements.heart.draw(canvas);
            startX += 150;
            endX += 150;
        }
    }



    void update() {
        if (!gameElements.hiddenState) {
            if (gameElements.showCount == gameElements.time) {
                for (Ball b : gameElements.balls) {
                    b.hide();
                    gameElements.memoryBall.show();
                    whooshSound.start();
                }
                gameElements.hiddenState = true;
            } else if (gameElements.showCount < gameElements.time) {
                gameElements.showCount++;
            }
        }

        if (gameElements.lives == 0){
            System.exit(0);
            reference.addListenerForSingleValueEvent(this);
        }
    }


    void select(float touchX, float touchY) {
        if (gameElements.hiddenState) {
            for (Ball b: gameElements.balls){
                if (b.contains(touchX, touchY) && !b.isTouched()) {
                    b.show();
                    b.setTouched(true);

                    if (b.equals(gameElements.memoryBall)) {
                        gameElements.score++;
                        gameElements.numberOfRefreshes = this.gameElements.numberOfRefreshes + 1;
                        if (gameElements.numberOfRefreshes % 3 == 0){
                            gameElements.level++;
                        }
                        this.success.start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        resetGame();
                    } else {
                        gameElements.lives--;
                        this.failure.start();
                    }
                }
            }
        }
    }

    private void resetGame(){
        gameElements.showCount = 0;
        gameElements.hiddenState = false;

        Collections.shuffle(gameElements.bitmapColours);
        for(int i = 0; i < 9; i++) {
            gameElements.balls.get(i).changeColour(gameElements.bitmapColours.get(i));
            gameElements.balls.get(i).show();
            gameElements.balls.get(i).setTouched(false);
        }
        gameElements.memoryBall.changeColour(gameElements.bitmapColours.get(ThreadLocalRandom.current().nextInt(0, 9)));
        gameElements.memoryBall.hide();
        whooshSound.start();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        Long oldScore = (Long) dataSnapshot.child("level3").getValue();
        if(oldScore < gameElements.score)
            this.reference.child("level3").setValue(gameElements.score);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
