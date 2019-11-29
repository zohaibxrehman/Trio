package com.example.game.Level2.Presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.game.Level2.View.MainThread;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
  private MainThread thread;
  private GameManager gameManager;
  public static float charHeight;
  public static float charWidth;
  public static int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
  private Context context;
  public int gameMode;

  public GameView(Context context, int gameMode) {
    super(context);
    getHolder().addCallback(this);
    thread = new MainThread(getHolder(), this);
    setFocusable(true);
    this.context = context;
    this.gameMode = gameMode;
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    gameManager =
        new GameManager(
            (int) (screenHeight / charHeight), (int) (screenWidth / charWidth), gameMode);
    thread.setRunning(true);
    thread.start();
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    boolean retry = true;
    while (retry) {
      try {
        thread.setRunning(false);
        thread.join();
      } catch (Exception e) {
        e.printStackTrace();
      }
      retry = false;
    }
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
      gameManager.buttonPressed(event.getX(), event.getY());
    }
    return true;
  }

  @Override
  public void draw(Canvas canvas) {
    super.draw(canvas);
    gameManager.draw(canvas);
  }
}
