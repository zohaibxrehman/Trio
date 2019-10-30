package com.example.game.Level3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.example.game.R;

import java.util.ArrayList;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private GameManager level1Manager;
    ArrayList<Integer> colours;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);

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
        level1Manager = new GameManager(bmpColours());

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
        level1Manager.update();

    }

    private ArrayList<Bitmap> bmpColours() {

        ArrayList<android.graphics.Bitmap> bitmapColours = new ArrayList<>();
//        Collections.shuffle(colours);
        for(int i = 0; i < 9; i++){
            bitmapColours.add(BitmapFactory.decodeResource(getResources(), colours.get(i)));
        }

        return bitmapColours;
    }

    @Override
    public void draw(Canvas canvas)
    {

        super.draw(canvas);
        if(canvas!=null) {
            level1Manager.draw(canvas);
        }

    }
}
