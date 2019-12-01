package com.example.game.Level3.GameLogic;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import androidx.annotation.NonNull;

import com.example.game.GameStats;
import com.example.game.Level3.Entities.Ball;
import com.example.game.Level3.GameElements.GameBuilder;
import com.example.game.Level3.GameElements.GameElements;
import com.example.game.Level3.GameElements.GameEngineer;
import com.example.game.Level3.Sound.SoundBuilder;
import com.example.game.Level3.Sound.SoundEngineer;
import com.example.game.Level3.Sound.SoundFacade;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class GameManager implements ValueEventListener{
    public String name;
    private DatabaseReference reference;
    private GameElements gameElements;
    private SoundFacade soundFacade;
    private GameStates gameStates;

    public GameManager(ArrayList<Bitmap> bitmapColours, Drawable heart, int time, MediaPlayer success, MediaPlayer failure, MediaPlayer whoosh, MediaPlayer boost, String name) {
        GameBuilder gameBuilder = new GameBuilder(bitmapColours, heart, time);
        GameEngineer gameEngineer = new GameEngineer(gameBuilder);
        gameEngineer.constructGame();
        this.gameElements = gameEngineer.getGameElements();


        SoundBuilder soundBuilder = new SoundBuilder(success, failure, whoosh, boost);
        SoundEngineer soundEngineer = new SoundEngineer(soundBuilder);
        soundEngineer.constructSound();
        this.soundFacade = soundEngineer.getSoundFacade();

        gameStates = new GameStates();

        this.name = name;
        this.reference = FirebaseDatabase.getInstance().getReference().child(name);
        Collections.shuffle(gameElements.bitmapColours);
    }

    public void draw(Canvas canvas) {
        for (Ball ball: this.gameElements.balls) {
            if (ball != null)
                ball.draw(canvas);
        }

        this.gameElements.memoryBall.draw(canvas);

        Paint style = new Paint();
        style.setColor(Color.WHITE);
        style.setTextSize(100);

        canvas.drawText("Score: " + this.gameElements.score, 700, 1800, style);
        canvas.drawText("Level: " + this.gameElements.level, 700, 1700, style);


        int startX = 25;
        int endX = 175;
        for (int i = 0; i < this.gameElements.lives; i++){
            this.gameElements.heart.setBounds(startX, 1850, endX, 2000);
            this.gameElements.heart.draw(canvas);
            startX += 150;
            endX += 150;
        }
    }


    public void update() {
        this.gameStates.memoriseState(gameElements, soundFacade);
        this.gameOver();
    }

    public void select(float touchX, float touchY) {
        gameStates.rememberState(touchX, touchY, gameElements, soundFacade);
    }

    private void gameOver(){
        if (this.gameElements.lives == 0){
            this.soundFacade.boost.start();

            reference.addListenerForSingleValueEvent(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.soundFacade.whooshSound.start();

            System.exit(0);
        }
    }


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        Long oldScore = (Long) dataSnapshot.child("level3").getValue();
        if(oldScore < this.gameElements.score)
            this.reference.child("level3").setValue(this.gameElements.score);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
