package com.example.game.Level1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.View;

public class Ball {
    public float x, y;
    private int color;
    private boolean red;

    public Ball(float x, float y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.red = true;
    }

    public boolean getRed(){
        return red;
    }


    public boolean contains(float l, float m){
        if(x - 100 <= l && l <= x + 100){
            if(y - 100 <= m && m <= y + 100)
                return true;
        }
        return false;
    }

    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(color);
        c.drawCircle(this.x, this.y, 100, p);
    }

    public void setColor(){
        if(this.red)
            this.color = Color.RED;
        else
            this.color = Color.GREEN;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void setColor1(int green) {
        this.color = green;
    }
}
