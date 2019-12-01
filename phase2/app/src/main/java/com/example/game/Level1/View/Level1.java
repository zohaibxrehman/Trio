//package com.example.game.Level1;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.Window;
//import android.view.WindowManager;
//
//public class Level1 extends Activity {
//    @Override
//    protected void onCreate(Bundle savedInstances) {
//        super.onCreate(savedInstances);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        String color, time, point;
//        color = getIntent().getStringExtra("COLOR");
//        time = getIntent().getStringExtra("TIME");
//        point = getIntent().getStringExtra("POINTS");
//
//
//        setContentView(new Level1view(this,time, color, point));
//    }
//
//}

package com.example.game.Level1.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Level1 extends Activity {// Game1View{
   // Game1Presenter presenter;
    float x,y;
    @Override
    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String background, ballcolor, difficulty;
        background = getIntent().getStringExtra("COLOR");
       // System.out.println(color);
        ballcolor = getIntent().getStringExtra("TIME");
        difficulty = getIntent().getStringExtra("POINTS");
        String username = getIntent().getStringExtra("name");

      //  presenter = new Game1Presenter(this);
        int gameMode = getIntent().getIntExtra("gameMode",1);
        System.out.print(gameMode+"ABCDEFHGJ");
        //System.out.println(time);
       // System.out.println(point);
        System.out.println(difficulty + "XXXXXXXXXXXXXXXXXXXXxx");
        setContentView(new Level1view(this, background, ballcolor, difficulty, username, gameMode));//, presenter));


    }



//    @Override
//    public void moveToNextGame() {
//
//        startActivity(new Intent(this, Level2Activity.class));
//
//    }



}
