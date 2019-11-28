package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.game.Level1.Customise1;
import com.example.game.Level1.View.Level1;
import com.example.game.Level2.Game2Instructions;
import com.example.game.Level2.Level2Activity;
import com.example.game.Level3.Level3;
import com.example.game.Level3.customise;


public class Main2Activity extends Activity implements View.OnClickListener{
    private ImageButton b1, b2, b3, b4;
    private int saveGame1Count = 0;
    private int saveGame2Count = 0;
    private int saveSecondGameCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
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
                saveGame1Count = 0;
                startActivity(i);
                break;
            case R.id.imageButtonGame2:
                Intent i2 = new Intent(this, Game2Instructions.class);
                saveSecondGameCount = 0;
                startActivity(i2);
                break;
            case R.id.imageButtonGame3:
                Intent i3 = new Intent(this, customise.class);
                saveGame2Count = 0;
                startActivity(i3);
                break;
            case R.id.imageButtonScore:
                if (saveGame1Count == 0 && saveGame2Count == 0){
                    saveData(String.valueOf(Integer.valueOf(loadData("guest", "total"))+ com.example.game.Level1.Entities.GameManager.finalScore+com.example.game.Level3.GameManager.score),"guest", "total");
                    saveGame1Count++;
                    saveGame2Count++;
                }else if(saveGame1Count == 0){
                    saveData(String.valueOf(Integer.valueOf(loadData("guest", "total"))+ com.example.game.Level1.Entities.GameManager.finalScore),"guest", "total");
                    saveGame1Count++;
                } else if(saveGame2Count == 0){
                    saveData(String.valueOf(Integer.valueOf(loadData("guest", "total"))+ com.example.game.Level3.GameManager.score),"guest", "total");
                    saveGame2Count++;
                }
                Intent j = new Intent(this, GameStats.class);
                startActivity(j);
                break;
        }
    }

    public void saveData(String score, String user, String game) {
        SharedPreferences sharedPreferences = getSharedPreferences(user, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(game, score);

        editor.apply();
    }

    public String loadData(String user, String game) {
        SharedPreferences sharedPreferences = getSharedPreferences(user, MODE_PRIVATE);
        return sharedPreferences.getString(game, "0");
    }
}