package com.example.game.Level2.Model;

import android.graphics.Color;

public class LeftBall extends Drawableball {
    private boolean touched;

    LeftBall(float x, float y, int color) {
        super(x, y, color);
        this.touched = false;
    }

    public boolean getTouched() {
        return touched;
    }

    public void setTouched() {
        this.touched = true;
    }

    public void setColor() {
        if (this.pair.getIsTarget()) {
            this.color = Color.GREEN;
            this.pair.color = Color.GREEN;
        } else {
            this.color = Color.RED;
            this.pair.color = Color.RED;
        }
    }
}
