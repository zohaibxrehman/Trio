//package com.example.game;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.example.game.Level1.Level1;
//
//
//public class MainActivity extends Activity implements View.OnClickListener {
//    private Button b1, b2, b3, b4;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        b1 = (Button) findViewById(R.id.button1);
//        b2 = (Button) findViewById(R.id.button2);
//        b3 = (Button) findViewById(R.id.button3);
//        b4 = (Button) findViewById(R.id.button4);
//        b1.setOnClickListener(this);
//        b2.setOnClickListener(this);
//        b3.setOnClickListener(this);
//        b4.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch(v.getId()){
//            case R.id.button3:
//                Intent i = new Intent(this, Level1.class);
//                startActivity(i);
//                break;
//            case R.id.button4:
//                Intent j = new Intent(this, GameStats.class);
//                startActivity(j);
//                break;
//
////        if(){
////            Intent Level1 = new Intent(getApplicationContext(),GameStats.class);
////            Intent Level2 = new Intent(getApplicationContext(),GameStats.class );
////            Intent Level3 = new Intent(getApplicationContext(), GameStats.class);
////            Level1.putExtra("YOuroutput",);
////            Level2.putExtra("your output",);
////            Level3.putExtra("your output",);
////
////
////        }else{
////        }
////        }
//
//    }
//
//}}
package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.game.Level1.Level1;



public class MainActivity extends Activity implements View.OnClickListener{
    private Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button1:
                Intent i = new Intent(this, Level1.class);
                startActivity(i);
                break;
//            case R.id.button4:
//                Intent j = new Intent(this, GameStats.class);
//                startActivity(j);
//                break;
//    public void button1(View view)
//    {
//        setContentView(new Level1view(this));
//    }

//        }
//            Intent Level1 = new Intent(getApplicationContext(),GameStats.class);
//            Intent Level2 = new Intent(getApplicationContext(),GameStats.class );
//            Intent Level3 = new Intent(getApplicationContext(), GameStats.class);
//            Level1.putExtra("YOuroutput",);
//            Level2.putExtra("your output",);
//            Level3.putExtra("your output",);



}}}