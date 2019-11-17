package com.example.game.Level1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.ArrayList;

/**
 * Manages how the game is run and displayed on the screen
 * */

public class GameManager {

    protected static int gridHeight;
    protected static int gridWidth;
    protected Ball b;
    protected Button left;
    protected Button right;
    Paint paintText = new Paint();
    boolean flag = false;
    String ballColor;
    int points;
    public static int finalScore=0;

    ArrayList<Barrier> items = new ArrayList<Barrier>();

    public GameManager(int height, int width, String ballColor, String points) {
        gridHeight = height;
        gridWidth = width;
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        this.ballColor = ballColor;
        if (points.equals("EASY"))
            this.points = 10;
        else
            this.points = 15;
        paintText.setColor(Color.WHITE);

    }

    /**
     * Creates the items displayed on the screen
     */
    public void createItems()
    {
        Barrier b1 = new Barrier(0);
        items.add(b1);
        Barrier b2 = new Barrier(10);
        items.add(b2);
        Barrier b3 = new Barrier(20);
        items.add(b3);
        Barrier b4 = new Barrier(30);
        items.add(b4);

        b = new Ball(15, 40, ballColor);

        // button
        left = new Button(Level1view.leftButtonImage, 100, 1800);
        right = new Button(Level1view.rightButtonImage, 800, 1800);

    }

    /**
     * Updates the state of the game objects.
     * */
    public void update()
    {
        for(int i = 0; i<items.size();i++)
        {
            items.get(i).move();
            Barrier temp = items.get(items.size()-1);
            if(temp.getHeight() == 39)
            {
                if(!temp.contains(b.getX())) {
                    this.flag = true;
                    this.draw(Level1view.can);
                }
            }
        }
        deleteAndAddBarrier();
    }

    /**
     * Draws out the game objects on the canvas.
     * @param canvas    where to draw the objects
     */
    public void draw(Canvas canvas)
    {

        if(flag)
        {
            canvas.drawText("YOU LOSE", 400, 800, paintText);
            Level1view.gameRunning = false;
        }
        else if(finalScore < points) {
            canvas.drawText("SCORE:" + finalScore, 60, 55, paintText);
        }
        if(finalScore == points)
        {
            canvas.drawText("YOU WON", 400, 800, paintText);
            Level1view.gameRunning = false;
        }

        for(int i = 0; i<items.size(); i++)
        {
            items.get(i).draw(canvas);
        }
        b.draw(canvas);
        left.draw(canvas);
        right.draw(canvas);
    }

    /**
     * Helper method to delete and add the barrier when gone from which have gone off the screen
     */

    private void deleteAndAddBarrier()
    {
        for(int i=0;i<items.size();i++)
        {
            Barrier temp = items.get(i);
            if(temp.getHeight() > 40)
            {
                removeBarrier(temp);
                finalScore += 1;
                addBarrierAtTop();
            }
        }
    }

    /**
     * Helper method to remove the barrier that have gone from the screen.
     * @param b     barrier which has gone off the screen.
     */
    private void removeBarrier(Barrier b)
    {
        items.remove(b);
    }

    /**
     * Helper to add the barrier to the top of the screen
     */
    private void addBarrierAtTop()
    {
        int newBarrierHeight = items.get(0).getHeight();
        newBarrierHeight -= 10;
        // Adds barrier at the top
        Barrier b = new Barrier(newBarrierHeight);
        items.add(0, b);
    }

    /**
     * Responds to the button either left or right button pressed.
     *
     * @param x     the x coordinate of the tap
     * @param y     the y coordinate of the tap
     */
    public void buttonPressed(int x, int y)
    {
        if(left.contains(x, y)) {
            b.moveLeft();
        }
        else if(right.contains(x, y)) {
            b.moveRight();
        }
    }
}