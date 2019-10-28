package com.example.game.Level1;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import androidx.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{
    private MainThread t;
    public Ball b1, b2 ,b3, b4, b5, b6, b7, b8, b9, last_ball;
    Canvas c;
    public GameView(Context c){
        super(c);
        getHolder().addCallback(this);
        this.t = new MainThread(getHolder(), this);
        int[] colors = {Color.WHITE, Color.BLACK, Color.RED, Color.YELLOW, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA,Color.LTGRAY};
        setFocusable(true);
        b1 = new Ball(200, 300, Color.WHITE);
        b2 = new Ball(550, 300, Color.BLACK);
        b3 = new Ball(900, 300, Color.RED);
        b4 = new Ball(200, 700, Color.YELLOW);
        b5 = new Ball(550, 700, Color.BLUE);
        b6 = new Ball(900, 700, Color.CYAN);
        b7 = new Ball(200, 1100, Color.GREEN);
        b8 = new Ball(550, 1100, Color.MAGENTA);
        b9 = new Ball(900, 1100, Color.LTGRAY);
        int r = (int)(Math.random() * 8);
        last_ball = new Ball(550, 1500, colors[r]);
        switch(r){
            case 0: b1.setRed(false);
                break;
            case 1: b2.setRed(false);
                break;
            case 2: b3.setRed(false);
                break;
            case 3: b4.setRed(false);
                break;
            case 4: b5.setRed(false);
                break;
            case 5: b6.setRed(false);
                break;
            case 6: b7.setRed(false);
                break;
            case 7: b8.setRed(false);
                break;
            case 8: b9.setRed(false);
                break;
        }

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        t.setrun(true);
        t.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        if(t.getTime() >= 100)
            this.t.onTouch(this, e);
        return true;
    }

    public void update(){
    }

    public void draw(Canvas c, int t){
        this.c = c;
        super.draw(c);
        c.drawColor(Color.DKGRAY);
        b1.draw(c);
        b2.draw(c);
        b3.draw(c);
        b4.draw(c);
        b5.draw(c);
        b6.draw(c);
        b7.draw(c);
        b8.draw(c);
        b9.draw(c);
        if(t >= 100){
            last_ball.draw(c);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean r = true;
        while(r){
            try{
                t.setrun(false);
                t.join();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            r = false;
        }
    }

}
