package com.example.game.Level1.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.View;
import android.widget.Button;

import com.example.game.Level2.View.Level2Activity;
import com.example.game.R;

public class LevelSelection extends Activity implements View.OnClickListener {
    public String gameMode;
    private Button b1, b2, b3;
    String username;
    String background, ballcolor, difficulty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        b1 = findViewById(R.id.button7);
        b2 = (Button)findViewById(R.id.button8);
        b3 = (Button)findViewById(R.id.button9);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        username = getIntent().getStringExtra("name");


    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button7:
                Intent intent = new Intent(this, Level1.class);
                intent.putExtra("name", username);
                background = getIntent().getStringExtra("COLOR");

                ballcolor = getIntent().getStringExtra("TIME");
                difficulty = getIntent().getStringExtra("POINTS");
                intent.putExtra("COLOR", background);
                intent.putExtra("TIME", ballcolor);
                intent.putExtra("POINTS", difficulty);

                intent.putExtra("gameMode", 1);
                startActivity(intent);
                break;
            case R.id.button8:
                Intent intent2 = new Intent(this, Level1.class);
                intent2.putExtra("name", username);
                background = getIntent().getStringExtra("COLOR");

                ballcolor = getIntent().getStringExtra("TIME");
                difficulty = getIntent().getStringExtra("POINTS");
                intent2.putExtra("COLOR", background);
                intent2.putExtra("TIME", ballcolor);
                intent2.putExtra("POINTS", difficulty);
                intent2.putExtra( "gameMode", 2);
                startActivity(intent2);
                break;

            case R.id.button9:
                Intent intent3 = new Intent(this, Level1.class);
                intent3.putExtra("name", username);
                background = getIntent().getStringExtra("COLOR");

                ballcolor = getIntent().getStringExtra("TIME");
                difficulty = getIntent().getStringExtra("POINTS");
                intent3.putExtra("COLOR", background);
                intent3.putExtra("TIME", ballcolor);
                intent3.putExtra("POINTS", difficulty);
                intent3.putExtra("gameMode", 3);
                startActivity(intent3);
                break;
        }
//    }
//    public void Mode1Game(View view) {
//        Intent intent = new Intent(this, Level1.class);
//        intent.putExtra(gameMode, 1);
//        startActivity(intent);
//    }
//
//    public void Mode2Game(View view){
//        Intent intent = new Intent(this, Level1.class);
//        intent.putExtra(gameMode, 2);
//        startActivity(intent);
//    }
//
//    public void Mode3Game(View view){
//        Intent intent = new Intent(this, Level1.class);
//        intent.putExtra(gameMode, 3);
//        startActivity(intent);
//    }

    }}
