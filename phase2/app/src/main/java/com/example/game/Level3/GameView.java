package com.example.game.Level3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.example.game.R;

import java.util.ArrayList;
import java.util.Collections;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private GameManager level1Manager;
    private String time, color, point;
    Drawable background;
    Drawable heart;
    ArrayList<Integer> colours;
    MediaPlayer success;
    private MediaPlayer failure;

    public GameView(Context context, String time, String color, String point) {
        super(context);
        this.point = point;
        this.time = time;
        this.color = color;

        getHolder().addCallback(this);
        this.success = MediaPlayer.create(context, R.raw.success);
        this.failure = MediaPlayer.create(context, R.raw.failure);

        int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        if(this.color.equals("Forest"))
            background = getResources().getDrawable(R.drawable.forest, null);
        else
            background = getResources().getDrawable(R.drawable.city, null);
        background.setBounds(0   , 0, screenWidth, screenHeight);

        heart = getResources().getDrawable(R.drawable.heart, null);

        thread = new MainThread(getHolder(), this);

        setFocusable(true);
        colours = new ArrayList<>();

        colours.add(R.drawable.bluecircle);
        colours.add(R.drawable.greencircle);
        colours.add(R.drawable.pinkcircle);
        colours.add(R.drawable.orangecircle);
        colours.add(R.drawable.redcircle);
        colours.add(R.drawable.yellowcircle);
        colours.add(R.drawable.purplecircle);
        colours.add(R.drawable.browncircle);
        colours.add(R.drawable.seagreen);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            level1Manager.select(event.getX(), event.getY());
        }

        return super.onTouchEvent(event);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Ball.hiddenImage = BitmapFactory.decodeResource(getResources(), R.drawable.greycircle);
        int c = 0;
        int p =0;
        if(point.equals("EASY"))
            p = 3;
        else
            p = 5;

        if(time.equals("3 seconds"))
            level1Manager = new GameManager(bmpColours(), heart,25, p);
        else
            level1Manager = new GameManager(bmpColours(), heart,50, p);
        level1Manager.addSuccessSound(success);
        level1Manager.addFailureSound(failure);
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch(InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
//        int p;
//        if(point.equals("EASY"))
//            p = 3;
//        else
//            p = 5;
//        if (GameManager.score == p){
//            thread.setRunning(false);
//        }
        level1Manager.update();

    }

    private ArrayList<Bitmap> bmpColours() {

        ArrayList<android.graphics.Bitmap> bitmapColours = new ArrayList<>();
        Collections.shuffle(colours);
        for(int i = 0; i < 9; i++){
            bitmapColours.add(BitmapFactory.decodeResource(getResources(), colours.get(i)));
        }

        return bitmapColours;
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        background.draw(canvas);

        if(canvas!=null) {
            level1Manager.draw(canvas);
        }

    }
}
