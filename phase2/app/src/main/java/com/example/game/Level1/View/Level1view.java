package com.example.game.Level1.View;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.game.Level1.Entities.GameManager;
import com.example.game.Level1.Logic.Game1Presenter;
import com.example.game.Level1.Logic.Game1View;
import com.example.game.Level2.View.Game2Instructions;
import com.example.game.R;

/**
 * Class for the view of the game
 */
@SuppressLint("ViewConstructor")
public class Level1view extends SurfaceView implements SurfaceHolder.Callback, Game1View {

    public static float charHeight;
    public static float charWidth;
    public GameManager gameManager;
    public static Bitmap heart;
    public static boolean gameRunning ;
    private MainThread thread;
    private String background, ballcolor, difficulty;
    public static Canvas can;
    private Game1Presenter presenter;
    private Context context;
    private String username;
    int gameMode;



    public Level1view(Context context, String background, String ballcolor, String difficulty, String username, int gameMode)
    {
        super(context);
        this.username = username;
        this.context = context;
        this.gameMode = gameMode;
        //this.presenter = presenter;
        presenter = new Game1Presenter(this);
        this.background = background;
        this.ballcolor = ballcolor;
        this.difficulty = difficulty;
        getHolder().addCallback(this);
        this.thread = new MainThread(getHolder(), this);
        setFocusable(true);
        gameRunning = true;
        heart = BitmapFactory.decodeResource(getResources(), R.drawable.heart);
        heart = Bitmap.createScaledBitmap(heart, 60, 60, true);

    }
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }

    public void surfaceCreated(SurfaceHolder holder)
    {


        Paint paintText = new Paint();
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        charWidth = paintText.measureText("W");
        charHeight = (-paintText.ascent() + paintText.descent());
        System.out.println("this height");
        System.out.println(charHeight);
        System.out.println(charWidth);

        gameManager = new GameManager(difficulty, ballcolor,username, gameMode);//, presenter);
        gameManager.createItems();
        thread.setRunning(true);
        thread.start();
    }

    /**
     *  to destroy the surface.
     */
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry)
        {
            try {
                thread.setRunning(false);
                thread.join();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    /**
     * draws the bitmap and objects on the canvas.
     *
     * @param canvas    where the objects are drawn.
     */
    public void draw(Canvas canvas) {
        super.draw(canvas);
        can = canvas;
        if (background.equals("forest")){
            Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.forest);
            background = Bitmap.createScaledBitmap(background, 1500, 2000, true);
            canvas.drawBitmap(background, 0, 0, null);
        }
        if (canvas != null) {
            boolean checker = presenter.draw(canvas, gameManager);
            if (!checker) {
                System.exit(0);
            }


        }

    }

    /**
     * updates the running thread
     */
    public void update()
    {
        if(gameRunning) {
            presenter.update(gameManager);
        }
    }

    /**
     * Records the touch on the screen.
     *
     * @return      returns either touched or not.
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_MOVE) {
            int touchX = (int) event.getX();

            presenter.ballMove(touchX, gameManager);
        }
        return true;
    }

    @Override
    public void moveToNextGame() {
        context.startActivity(new Intent(this.context, Game2Instructions.class));
    }
}