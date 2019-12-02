package com.example.game.Level1.Entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
/**
 * For having the barrier of the game
 */
public class Barrier{
    private int end;

    private float height;
    private int start;
    private Paint paintText = new Paint();
    private String type;

    Barrier(float height, String type) {

        this.height = height;
        this.type = type;
        if(this.type.equals("BB"))
        {
            paintText.setColor(Color.rgb(0, 0, 225));
        }
        else if(this.type.equals("WB"))
        {
            paintText.setColor(Color.rgb(255, 255, 255));
        }
        else if(this.type.equals("YB"))
        {
            paintText.setColor(Color.rgb(255, 255, 0));
        }
        start = 250 + (int)(Math.random() * 400);
    }

    /**
     * To draw the barrier on the canvas.
     * @param canvas    where to draw the barrier
     */
    public void draw(Canvas canvas) {

        end = start + 250;
        // creates the blue barrier
        if(this.type.equals("BB")) {
            canvas.drawRoundRect(-10, height * 42, start, (height + 1) * 42, 100, 100, paintText);

            canvas.drawRoundRect(end, height * 42, end + 600, (height + 1) * 42, 100,
                    100, paintText);
        }
        // creates the white barrier
        else if(this.type.equals("WB"))
        {
            canvas.drawRoundRect(this.start, height * 42, end, (height + 1) * 42, 100, 100, paintText);
        }
        // creates the yellow barrier
        else if(this.type.equals("YB"))
        {
            canvas.drawRoundRect(start, height * 42, end, (height + 1) * 42, 100,
                    100, paintText);
        }
        try
        {
            Thread.sleep(15);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Moves the barrier downwards
     */

    void move()
    {
        this.height += 1;
    }

    /**
     * Checks if the ball has passed through the barrier.
     *
     * @param x     the x coordinate of the ball.
     * @return      return if the ball has passed through or not.
     */
    boolean contains(int x) {
        // this.score += 1;
        if(this.type.equals("BB")) {
            return (this.start) <= x && x <= ((this.end));
        }
        else if(this.type.equals("WB"))
        {
            return !((this.start) <= x && x <= ((this.end)));
        }
        else if(this.type.equals("YB"))
        {
            return ((this.start) <= x && x <= ((this.end)));
        }
        else
        {
            return false;
        }
    }


    /**
     * returns the height of this barrier.
     * @return       returns the height.
     */
    float getHeight()
    {
        return this.height;
    }

}
