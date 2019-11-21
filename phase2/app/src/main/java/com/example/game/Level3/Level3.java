package com.example.game.Level3;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.game.R;

public class Level3 extends Activity {
    private MediaPlayer backgroundMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backgroundMusic = MediaPlayer.create(this, R.raw.backgroundmusic);
        backgroundMusic.setLooping(true);
        backgroundMusic.start();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String color, time, point;
        color = getIntent().getStringExtra("COLOR");
        time = getIntent().getStringExtra("TIME");
        point = getIntent().getStringExtra("POINTS");
        setContentView(new GameView(this, time, color, point));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        backgroundMusic.release();
        backgroundMusic = null;

    }


}