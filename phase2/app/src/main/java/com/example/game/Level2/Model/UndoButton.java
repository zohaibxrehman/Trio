package com.example.game.Level2.Model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class UndoButton implements Drawable {

    @Override
    public void draw(Canvas c) {
        Paint p = new Paint();
        p.setStrokeWidth(10);
        p.setColor(Color.GRAY);
        c.drawCircle(550, 1700, 300, p);
        p.setTextSize(150);
        p.setColor(Color.RED);
        c.drawText("UNDO?", 300,1750,p);
    }

    public boolean contains(float l, float m) {
        if (550 - 300 <= l && l <= 550 + 300) {
            return 1700 - 300 <= m && m <= 1700 + 300;
        }
        return false;
    }
}
