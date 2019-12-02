package com.example.game.Level2.Model;

import android.graphics.Color;
import android.media.CamcorderProfile;

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

    public void setColor(int color) {
        this.color = color;
        this.pair.color = color;
    }

    public void undo(){
        this.color = Color.BLUE;
        this.touched = false;
        this.pair.color = Color.BLUE;
    }
}
