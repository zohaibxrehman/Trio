////package com.example.game.Level1;
////
////import android.graphics.Canvas;
////import android.graphics.Color;
////import android.graphics.Paint;
////import android.graphics.Typeface;
////import android.widget.Button;
////
////import androidx.annotation.Dimension;
////
////
////public class ChildBall {
////
////    public int x;
////    public int y;
////    String ballColor;
////    Color color;
////
////    Paint paintText = new Paint();
////
////    public ChildBall(int x, int y, String ballColor) {
////        this.x = x;
////        this.y = y;
////        paintText.setTextSize(36);
////        paintText.setTypeface(Typeface.DEFAULT_BOLD);
//////        this.ballColor = ballColor;
////        if (ballColor.equals("red"))
////            paintText.setColor(Color.RED);
////        else
////            paintText.setColor(Color.YELLOW);
////    }
////
////    public void moveRight() {
////        if (this.x*Level1view.charWidth < Level1view.screenWidth) {
////            x++;
////        }
////    }
////
////    public void moveLeft() {
////        if(this.y*Level1view.charHeight > 0) {
////            x--;
////        }
////    }
////
////    public void draw(Canvas canvas) {
////
////        canvas.drawCircle(this.x*Level1view.charWidth, this.y*Level1view.charHeight, 50, paintText);
////
////    }
////
////}
//package com.example.game.Level1;
//
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Typeface;
//
//
///**
// * The ball displayed on the screen.
// */
//public class Ball {
//
//    private int x;
//    private int y;
//
//    Paint paintText = new Paint();
//
//    public Ball(int x, int y, String ballColor) {
//        this.x = x;
//        this.y = y;
//        paintText.setTextSize(36);
//        paintText.setTypeface(Typeface.DEFAULT_BOLD);
//        if (ballColor.equals("red"))
//            paintText.setColor(Color.RED);
//        else
//            paintText.setColor(Color.YELLOW);
//    }
//
//    /**
//     * moves the ball to the right.
//     */
//    protected void moveRight() {
//        if (this.x*Level1view.charWidth < Level1view.screenWidth) {
//            x++;
//        }
//    }
//
//    /**
//     * Moves the ball to the left.
//     */
//    protected void moveLeft() {
//        if(this.y*Level1view.charHeight > 0) {
//            x--;
//        }
//    }
//
//    /**
//     *
//     * draws the ball on the canvas.
//     * @param canvas    where the ball is drawn.
//     */
//    public void draw(Canvas canvas) {
//
//        canvas.drawCircle(this.x*Level1view.charWidth, this.y*Level1view.charHeight,
//                50, paintText);
//
//    }
//
//    /**
//     * returns the x coordinate of the ball.
//     * @return      returns the x coordinate of the ball.
//     */
//    public int getX()
//    {
//        return this.x;
//    }
//}

package com.example.game.Level1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;


/**
 * The ball displayed on the screen.
 */
public class Ball {

    private int x;
    private int y;

    Paint paintText = new Paint();

    public Ball(int x, int y, String ballColor) {
        this.x = x;
        this.y = y;
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        if (ballColor.equals("red"))
            paintText.setColor(Color.RED);
        else
            paintText.setColor(Color.YELLOW);
    }

    /**
     * moves the ball to the right.
     */
    protected void moveRight() {
        if (this.x*Level1view.charWidth < Level1view.screenWidth) {
            x++;
        }
    }

    /**
     * Moves the ball to the left.
     */
    protected void moveLeft() {
        if(this.y*Level1view.charHeight > 0) {
            x--;
        }
    }

    /**
     *
     * draws the ball on the canvas.
     * @param canvas    where the ball is drawn.
     */
    public void draw(Canvas canvas) {

        canvas.drawCircle(this.x*Level1view.charWidth, this.y*Level1view.charHeight,
                50, paintText);

    }

    /**
     * returns the x coordinate of the ball.
     * @return      returns the x coordinate of the ball.
     */
    public int getX()
    {
        return this.x;
    }
}
