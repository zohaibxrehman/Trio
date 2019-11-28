package com.example.game.Level2;

import android.graphics.Color;

public class RightBall extends Drawableball {

    RightBall(float x, float y, int color){
        super(x,y,color);
    }

    @Override
    void setTarget(){
        this.isTarget = true;
        this.color = Color.YELLOW;
    }
}
