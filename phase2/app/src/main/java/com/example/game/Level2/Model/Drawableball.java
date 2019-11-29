package com.example.game.Level2.Model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Drawableball implements Drawable {
    private float x, y;
    Drawableball pair;
    int color;
    boolean isTarget;

    Drawableball(float x, float y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.isTarget = false;
    }

    public boolean getIsTarget() {
        return this.isTarget;
    }

    public void setTarget() {
        this.isTarget = true;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Drawableball getPair(){
        return this.pair;
    }

    public boolean contains(float l, float m) {
        if (x - 100 <= l && l <= x + 100) {
            return y - 100 <= m && m <= y + 100;
        }
        return false;
    }

    void setPair(Drawableball pair) {
        this.pair = pair;
    }


    @Override
    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        c.drawCircle(this.x, this.y, 110, p);
        p.setColor(color);
        c.drawCircle(this.x, this.y, 100, p);
    }
}
