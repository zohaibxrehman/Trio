package com.example.game.Level1;
import android.graphics.Canvas;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

public class MainThread extends Thread implements View.OnTouchListener {
    private com.example.game.Level1.GameView gameview;
    private SurfaceHolder surfaceholder;
    public Canvas canvas;
    private int time;
    private boolean running;

    public MainThread(SurfaceHolder s, com.example.game.Level1.GameView g){
        super();
        this.gameview = g;
        this.surfaceholder = s;
    }
    @Override
    public void run(){
        while(this.running) {
            try{ time ++;
                if(time == 100){
                    gameview.b1.setColor1(Color.WHITE);
                    gameview.b2.setColor1(Color.WHITE);
                    gameview.b3.setColor1(Color.WHITE);
                    gameview.b4.setColor1(Color.WHITE);
                    gameview.b5.setColor1(Color.WHITE);
                    gameview.b6.setColor1(Color.WHITE);
                    gameview.b7.setColor1(Color.WHITE);
                    gameview.b8.setColor1(Color.WHITE);
                    gameview.b9.setColor1(Color.WHITE);
                }
                canvas = this.surfaceholder.lockCanvas();
                this.gameview.update();
                this.gameview.draw(canvas, time);
                this.surfaceholder.unlockCanvasAndPost(canvas);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        float x1 = e.getX();
        float y1 = e.getY();
        boolean ct = false;
        if(gameview.b1.contains(x1, y1))
        {
            gameview.b1.setColor();
            ct = !(gameview.b1.getRed());
        }
        else if(gameview.b2.contains(x1, y1))
        {
            gameview.b2.setColor();
            ct = !(gameview.b2.getRed());
        }
        else if(gameview.b3.contains(x1, y1))
        {
            gameview.b3.setColor();
            ct = !(gameview.b3.getRed());
        }
        else if(gameview.b4.contains(x1, y1))
        {
            gameview.b4.setColor();
            ct = !(gameview.b4.getRed());
        }
        else if(gameview.b5.contains(x1, y1))
        {
            gameview.b5.setColor();
            ct = !(gameview.b5.getRed());
        }
        else if(gameview.b6.contains(x1, y1))
        {
            gameview.b6.setColor();
            ct = !(gameview.b6.getRed());
        }
        else if(gameview.b7.contains(x1, y1))
        {
            gameview.b7.setColor();
            ct = !(gameview.b7.getRed());
        }
        else if(gameview.b8.contains(x1, y1))
        {
            gameview.b8.setColor();
            ct = !(gameview.b8.getRed());
        }
        else if(gameview.b9.contains(x1, y1))
        {
            gameview.b9.setColor();
            ct = !(gameview.b9.getRed());
        }
        if(ct){
            setrun(false);
        }
        return true;
    }

    public void setrun(boolean b) {
        this.running = b;
    }

    public int getTime() {
        return time;
    }
}
