package com.example.game.Level2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Ball {
    private float x, y;
    private int color;
    private boolean touched;
    private Ball pair;
    private boolean target;



    Ball(float x, float y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.touched = false;
        this.target = false;
    }

    boolean isTarget() {
        return target;
    }

    void setTarget(){
        this.target = true;
    }

    void makeTarget(){
        this.color = Color.YELLOW;
    }

    void setTouched() {
        this.touched = true;
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

    boolean beenTouched() {
        return touched;

    }

    void setPair(Ball pair) {
        this.pair = pair;
    }

    Ball getPair() {
        return this.pair;
    }

    boolean contains(float l, float m) {
        if (x - 100 <= l && l <= x + 100) {
            return y - 100 <= m && m <= y + 100;
        }
        return false;
    }

    void draw(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        c.drawCircle(this.x, this.y, 110, p);
        p.setColor(color);
        c.drawCircle(this.x, this.y, 100, p);
    }

    void setColor() {
        if (this.pair.isTarget()) {
            this.color = Color.GREEN;
            this.pair.color = Color.GREEN;
        } else {
            this.color = Color.RED;
            this.pair.color = Color.RED;
        }
    }

}
