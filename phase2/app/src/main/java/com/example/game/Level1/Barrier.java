package com.example.game.Level1;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * For having the barrier of the game
 */
public class Barrier{
    private int l;
    Color colour;
    public int height;
    int start;
    int score;

    Paint paintText = new Paint();

    public Barrier(int height) {
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        this.height = height;
        paintText.setColor(-16041008);
        start = 5 + (int)(Math.random() * 15);
        this.score = 0;
    }

    /**
     * To draw the barrier on the canvas.
     * @param canvas    where to draw the barrier
     */
    public void draw(Canvas canvas) {


        canvas.drawRoundRect(0, height*Level1view.charHeight, start*Level1view.charWidth, (height+1)*Level1view.charHeight, 100, 100, paintText);
        int end = start + 10;
        canvas.drawRoundRect(end*Level1view.charWidth, height*Level1view.charHeight, Level1view.screenWidth, (height+1)*Level1view.charHeight, 100, 100, paintText);
        try
        {
            Thread.sleep(50);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Moves the barrier downwards
     */
    public void move()
    {
        // as we go lower on the screen, the height of object increases
        this.height += 1;
    }

    /**
     * Checks if the ball has passed through the barrier.
     *
     * @param x     the x coordinate of the ball.
     * @return      return if the ball has passed through or not.
     */
    protected boolean contains(int x) {
        if ((this.start) <= x && x <= (this.start + 10)) {
            this.score += 1;
            return true;
        }
        else
        {
            return false;
        }
    }

}