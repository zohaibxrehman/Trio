package com.example.game.Level2.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.Level2.Presenter.GameView;

import java.util.Objects;

public class Level2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String gameMode = intent.getStringExtra("gameMode");
        int gameModevalue = Integer.parseInt(Objects.requireNonNull(gameMode));
        Boolean hard = intent.getBooleanExtra("difficulty", false);
        setContentView(new GameView(this, gameModevalue, hard));
    }
}
