package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.game.Level1.Customise1;
import com.example.game.Level2.View.Game2Instructions;
import com.example.game.Level3.UserInterface.Customise;


/**
 * The activity for choosing which game to play.
 */
public class Main2Activity extends Activity implements View.OnClickListener{
    private ImageButton b1, b2, b3, b4;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = getIntent().getStringExtra("name");
        b1 = findViewById(R.id.imageButtonGame1);
        b2 = findViewById(R.id.imageButtonGame2);
        b3 = findViewById(R.id.imageButtonGame3);
        b4 = findViewById(R.id.imageButtonScore);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.imageButtonGame1:
                Intent i = new Intent(this, Customise1.class);
                i.putExtra("name", username);
                startActivity(i);
                break;
            case R.id.imageButtonGame2:
                Intent i2 = new Intent(this, Game2Instructions.class);
                i2.putExtra("name", username);
                startActivity(i2);
                break;
            case R.id.imageButtonGame3:
                Intent i3 = new Intent(this, Customise.class);
                i3.putExtra("name", username);
                startActivity(i3);
                break;
            case R.id.imageButtonScore:
                Intent j = new Intent(this, GameStats.class);
                j.putExtra("name", username);
                startActivity(j);
                break;
        }
    }
}