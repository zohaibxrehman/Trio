package com.example.game.Level2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

public class Level2view extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread t;
    Canvas c;
    public List<Ball> right = new ArrayList<>();
    List<Ball> left = new ArrayList<>();
    List<Line> lines = new ArrayList<>();

    public Level2view(Context c) {
        super(c);
        getHolder().addCallback(this);
        this.t = new MainThread(getHolder(), this);
        setFocusable(true);

        int[] colors = {Color.BLACK, Color.RED};
        int difficulty = 4;
        int count = 300;
        int r;
        for (int i = difficulty; i > 0; i--) {
            Ball b = new Ball(200, count, Color.BLACK);
            r = (int) (Math.random() * 2);
            Ball pair = new Ball(900, count, colors[r]);
            b.setPair(pair);
            right.add(pair);
            left.add(b);
            Line l = new Line(b.getX(), b.getY(), pair.getX(), pair.getY(), Color.BLACK);
            lines.add(l);
            count += 400;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        t.setrun(true);
        t.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        this.t.onTouch(this, e);
        return true;
    }

    public void update() {
    }

    public void draw(Canvas c) {
        this.c = c;
        super.draw(c);
        Paint p = new Paint();
        p.setShader(new LinearGradient(0, 0, 0, getHeight(), Color.BLACK, Color.WHITE, Shader.TileMode.MIRROR));
        c.drawPaint(p);
        for (int i = 0; i < right.size(); i++) {
            Ball b = right.get(i);
            Ball b2 = left.get(i);
            Line l = lines.get(i);
            b.draw(c);
            b2.draw(c);
            l.draw(c);
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean r = true;
        while (r) {
            try {
                t.setrun(false);
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = false;
        }
    }

}
