////package com.example.game.Level1;
////
////
////import android.graphics.Canvas;
////import android.graphics.Color;
////import android.graphics.Paint;
////import android.graphics.Typeface;
////
////
////public class Barrier{
////    private int l;
////    Color colour;
////    public int height;
////    int start;
////    int score;
////
////    Paint paintText = new Paint();
////
////    public Barrier(int height) {
////        paintText.setTextSize(36);
////        paintText.setTypeface(Typeface.DEFAULT_BOLD);
////        this.height = height;
////        paintText.setColor(-16041008);
////        start = 5 + (int)(Math.random() * 15);
////        this.score = 0;
////    }
////
////
////    public void draw(Canvas canvas) {
////
////
////        canvas.drawRoundRect(0, height*Level1view.charHeight, start*Level1view.charWidth, (height+1)*Level1view.charHeight, 100, 100, paintText);
////        int end = start + 10;
////        canvas.drawRoundRect(end*Level1view.charWidth, height*Level1view.charHeight, Level1view.screenWidth, (height+1)*Level1view.charHeight, 100, 100, paintText);
//////        for (int i = 0; i < 34; i++) {
//////            if(!(i >= start && i<= end)) {
//////                drawString(canvas, "=", height, i);
//////            }
//////
//////        }
////        try
////        {
////            Thread.sleep(50);
////        }
////        catch(InterruptedException e)
////        {
////            System.out.println(e);
////        }
////    }
////
////    private void drawString(Canvas canvas, String s, int x, int y) {
////        canvas.drawText(s, y * Level1view.charWidth, x * Level1view.charHeight, paintText);
////    }
////
////    protected void move()
////    {
////        this.height += 1;
////    }
////
////    protected boolean contains(int x) {
//////        return ((this.start*Level1view.charWidth) <= pressedX && pressedX <= ((this.start+10)*Level1view.charWidth));
////        if ((this.start) <= x && x <= (this.start + 10)) {
////            this.score += 1;
////            return true;
////        }
////        else
////        {
////            return false;
////        }
////    }
////
////}
//package com.example.game.Level1;
//
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Typeface;
//
///**
// * For having the barrier of the game
// */
//public class Barrier{
//
//
//    private int height;
//    int start;
//    int score;
//
//    Paint paintText = new Paint();
//
//    public Barrier(int height) {
//        paintText.setTextSize(36);
//        paintText.setTypeface(Typeface.DEFAULT_BOLD);
//        this.height = height;
//        paintText.setColor(-16041008);
//        start = 5 + (int)(Math.random() * 15);
//        this.score = 0;
//    }
//
//    /**
//     * To draw the barrier on the canvas.
//     * @param canvas    where to draw the barrier
//     */
//    public void draw(Canvas canvas) {
//
//
//        canvas.drawRoundRect(0, height*Level1view.charHeight, start*Level1view.charWidth, (height+1)*Level1view.charHeight, 100, 100, paintText);
//        int end = start + 10;
//        canvas.drawRoundRect(end*Level1view.charWidth, height*Level1view.charHeight, Level1view.screenWidth, (height+1)*Level1view.charHeight, 100, 100, paintText);
//        try
//        {
//            Thread.sleep(50);
//        }
//        catch(InterruptedException e)
//        {
//            System.out.println(e);
//        }
//    }
//
//    /**
//     * Moves the barrier downwards
//     */
//    public void move()
//    {
//        // as we go lower on the screen, the height of object increases
//        this.height += 1;
//    }
//
//    /**
//     * Checks if the ball has passed through the barrier.
//     *
//     * @param x     the x coordinate of the ball.
//     * @return      return if the ball has passed through or not.
//     */
//    protected boolean contains(int x) {
//        if ((this.start) <= x && x <= (this.start + 10)) {
//            this.score += 1;
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//
//    /**
//     * returns the height of this barrier.
//     * @return       returns the height.
//     */
//    protected int getHeight()
//    {
//        return this.height;
//    }
//
//}
package com.example.game.Level1.Entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.game.Level1.View.Level1view;
//import android.graphics.Typeface;

/**
 * For having the barrier of the game
 */
public class Barrier{
    private int end;

    private float height;
    // this is for the pickable life in the game
//    public boolean pickableLife;
    private int start;
    //private int score;
    private Paint paintText = new Paint();
    String type;

    Barrier(float height, String type) {
        //paintText.setTextSize(36);
        //paintText.setTypeface(Typeface.DEFAULT_BOLD);
        this.height = height;
        this.type = type;
        if(this.type.equals("BB"))
        {
            paintText.setColor(Color.rgb(0, 0, 225));
        }
        else if(this.type.equals("WB"))
        {
            paintText.setColor(Color.rgb(255, 255, 255));
        }
        else if(this.type.equals("YB"))
        {
            paintText.setColor(Color.rgb(255, 255, 0));
        }
        //paintText.setColor(-16041008);
        start = 350 + (int)(Math.random() * 400);
        //this.score = 0;
//        this.pickableLife = true;
    }

    /**
     * To draw the barrier on the canvas.
     * @param canvas    where to draw the barrier
     */
    public void draw(Canvas canvas) {



        end = start + 250;
        if(this.type.equals("BB")) {
            canvas.drawRoundRect(-10, height * 42, start, (height + 1) * 42, 100, 100, paintText);

            canvas.drawRoundRect(end, height * 42, end + 600, (height + 1) * 42, 100,
                    100, paintText);
        }
        else if(this.type.equals("WB"))
        {
            canvas.drawRoundRect(this.start, height * 42, end, (height + 1) * 42, 100, 100, paintText);
        }
        else if(this.type.equals("YB"))
        {
            canvas.drawRoundRect(start, height * 42, end, (height + 1) * 42, 100,
                    100, paintText);
        }
        try
        {
            Thread.sleep(15);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Moves the barrier downwards
     */
    void move()
    {
        // as we go lower on the screen, the height of object increases
        this.height += 1;
    }

    /**
     * Checks if the ball has passed through the barrier.
     *
     * @param x     the x coordinate of the ball.
     * @return      return if the ball has passed through or not.
     */
    boolean contains(int x) {
        // this.score += 1;
        if(this.type.equals("BB")) {
            return (this.start) <= x && x <= ((this.end));
        }
        else if(this.type.equals("WB"))
        {
            return !((this.start) <= x && x <= ((this.end)));
        }
        else if(this.type.equals("YB"))
        {
            return ((this.start) <= x && x <= ((this.end)));
        }
        else
        {
            return false;
        }
    }


    /**
     * returns the height of this barrier.
     * @return       returns the height.
     */
    float getHeight()
    {
        return this.height;
    }

}
