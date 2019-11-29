package com.example.game.Level2.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.R;

public class Game2Instructions extends Activity {
    public String gameMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.instructions);
    }
    public void Mode1Instructions(View view) {
        ((TextView) findViewById(R.id.InstructionsText)).setText("Instructions for Mode 1!");
    }

    public void Mode2Instructions(View view) {
        ((TextView) findViewById(R.id.InstructionsText)).setText("Instructions for Mode 2!");
    }

    public void Mode3Instructions(View view) {
        ((TextView) findViewById(R.id.InstructionsText)).setText("Instructions for Mode 3!");
    }

    public void Mode1Game(View view) {
        Intent intent = new Intent(this, Level2Activity.class);
        intent.putExtra(gameMode, 1);
        startActivity(intent);
    }

    public void Mode2Game(View view){
        Intent intent = new Intent(this, Level2Activity.class);
        intent.putExtra(gameMode, 2);
        startActivity(intent);
    }

    public void Mode3Game(View view){
        Intent intent = new Intent(this, Level2Activity.class);
        intent.putExtra(gameMode, 3);
        startActivity(intent);
    }

}
