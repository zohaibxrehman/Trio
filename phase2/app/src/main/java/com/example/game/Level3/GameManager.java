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
    private ArrayList<Ball> balls;
    private Ball memoryBall;
    private int showCount;
    private boolean hiddenState;
    public int score;
    private int time;
    private ArrayList<Bitmap> bitmapColours;
    private int lives;
    private int point;
    private Drawable heart;
    private MediaPlayer success;
    private MediaPlayer failure;
    private MediaPlayer whooshSound;
    public String name;
    private DatabaseReference reference;

    GameManager(ArrayList<Bitmap> bitmapColours, Drawable heart, int time, int p, String name) {
        balls = new ArrayList<>();
        hiddenState = false;
        this.time = time;
        this.point = p;
        showCount = 0;
        score = 0;
        lives = 7;
        this.name = name;
        this.heart = heart;
        this.reference = FirebaseDatabase.getInstance().getReference().child(name);
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

    void  addWhooshSound(MediaPlayer whoosh){
        this.whooshSound = whoosh;
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
                    whooshSound.start();
                }
                hiddenState = true;
            } else if (showCount < time) {
                showCount++;
            }
        }

        if (lives == 0){
//            System.exit(0);
            reference.addListenerForSingleValueEvent(this);
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
        whooshSound.start();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        Long oldScore = (Long) dataSnapshot.child("level3").getValue();
        if(oldScore < this.score)
            this.reference.child("level3").setValue(score);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
