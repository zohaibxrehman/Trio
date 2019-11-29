package com.example.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.game.Level1.Entities.GameManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.logging.Level;

public class GameStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_stats);
        final String username = getIntent().getStringExtra("name");
        TextView TotalScore = (TextView)findViewById(R.id.TotalScore);
        final TextView  Level1 = (TextView)findViewById(R.id.Level1);
        final TextView Level2 = (TextView)findViewById(R.id.Level2);
        final TextView Level3 = (TextView)findViewById(R.id.Level3);
        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child(username);
        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Level1.setText(dataSnapshot.child("level1").getValue().toString());
                Level2.setText(dataSnapshot.child("level2").getValue().toString());
                Level3.setText(dataSnapshot.child("level3").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        String Level2percent = Math.round(com.example.game.Level2.GameManager.percent) + "%";
//        Level1.setText(String.valueOf(GameManager.finalScore));
//        Level2.setText(Level2percent);
//        Level3.setText(String.valueOf(com.example.game.Level3.GameManager.score));
//        TotalScore.setText(loadData("guest", "total"));

    }

    public String loadData(String user, String game) {
        SharedPreferences sharedPreferences = getSharedPreferences(user, MODE_PRIVATE);
        return sharedPreferences.getString(game, "0");
    }
}
