package com.example.game.Level2;

import android.graphics.Color;

public class LeftBall extends Drawableball {
    private boolean touched;

    LeftBall(float x, float y, int color) {
        super(x, y, color);
        this.touched = false;
    }

    boolean getTouched() {
        return touched;
    }

    void setTouched() {
        this.touched = true;
    }

    void setColor() {
        if (this.pair.getIsTarget()) {
            this.color = Color.GREEN;
            this.pair.color = Color.GREEN;
        } else {
            this.color = Color.RED;
            this.pair.color = Color.RED;
        }
    }
}
