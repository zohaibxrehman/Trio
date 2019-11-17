package com.example.game.Level1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;


/**
 * The ball displayed on the screen.
 */
public class Ball {

    public int x;
    public int y;

    Paint paintText = new Paint();

    public Ball(int x, int y, String ballColor) {
        this.x = x;
        this.y = y;
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        if (ballColor.equals("red"))
            paintText.setColor(Color.RED);
        else
            paintText.setColor(Color.YELLOW);
    }

    /**
     * moves the ball to the right.
     */
    public void moveRight() {
        if (this.x*Level1view.charWidth < Level1view.screenWidth) {
            x++;
        }
    }

    /**
     * Moves the ball to the left.
     */
    public void moveLeft() {
        if(this.y*Level1view.charHeight > 0) {
            x--;
        }
    }

    /**
     *
     * draws the ball on the canvas.
     * @param canvas    where the ball is drawn.
     */
    public void draw(Canvas canvas) {

        canvas.drawCircle(this.x*Level1view.charWidth, this.y*Level1view.charHeight,
                50, paintText);

    }

}