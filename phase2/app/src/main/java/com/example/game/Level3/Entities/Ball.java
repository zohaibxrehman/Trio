package com.example.game.Level3.Entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Ball {

    private Bitmap currentImage;
    private Bitmap image;
    public static Bitmap hiddenImage;
    private int x, y;
    private boolean touched;

    public Ball(Bitmap bmp, int x, int y) {
        currentImage = bmp;
        image = bmp;
        this.x = x;
        this.y = y;
        touched = false;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(currentImage, x, y, null);
    }

    public void hide() {
        this.currentImage = hiddenImage;
    }

    public void show() {
        this.currentImage = image;
    }

    public boolean isTouched() {
        return touched;
    }

    public boolean contains(float touchX, float touchY) {
        return x <= touchX && touchX <= x + image.getWidth()
                && y <= touchY && touchY <= y + image.getHeight();
    }


    public void changeColour(Bitmap newBmp) {
        this.image = newBmp;
    }

    public void setTouched(boolean b){
        touched = b;
    }

    public boolean equals(Ball that) {
        return this.currentImage.sameAs(that.currentImage);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
