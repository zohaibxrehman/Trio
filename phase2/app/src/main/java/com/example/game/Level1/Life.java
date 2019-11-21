package com.example.game.Level1;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Tracks the lives inside the class.
 */
class Life {

    protected int x, y;
    protected Bitmap image;

    public Life(Bitmap image, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    /**
     * draws the object on the canvas.
     * @param canvas   where the heart is drawn.
     */
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y, null);
    }


}

