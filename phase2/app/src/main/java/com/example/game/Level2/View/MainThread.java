package com.example.game.Level2.View;


import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.game.Level2.Presenter.GameView;

public class MainThread extends Thread{
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;


    public MainThread(SurfaceHolder surfaceHolder, GameView gameView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    public void run()
    {
        while(running)
        {
            Canvas canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.draw(canvas);

                }
            }
            catch(Exception e){}

            finally
            {
                if(canvas !=null)
                {
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}