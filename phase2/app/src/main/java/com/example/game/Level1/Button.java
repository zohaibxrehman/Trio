package com.example.game.Level1;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * For the right and left buttons displayed on the screen.
 */
public class Button {

    private int x,y;
    Bitmap image;


    public Button(Bitmap bmp, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.image = bmp;
    }

    /**
     * draws the object on the canvas.
     * @param canvas   where the button is drawn.
     */
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y, null);
    }

    /**
     * Checks if the user has pressed the button.
     *
     * @param pressedX      the x coordinate of the press.
     * @param pressedY      the y coordinate of the press.
     * @return              whether or not the user has pressed the button.
     */
    protected boolean contains(int pressedX, int pressedY)
    {
        return ((this.x <= pressedX && pressedX <= this.x+image.getWidth())&&(this.y <= pressedY && pressedY <= this.y+image.getHeight()));
    }
}