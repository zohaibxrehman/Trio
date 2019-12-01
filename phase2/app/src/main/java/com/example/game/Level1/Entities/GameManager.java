////package com.example.game.Level1;
////
////import android.graphics.Canvas;
////import android.graphics.Color;
////import android.graphics.Paint;
////import android.graphics.Typeface;
////
////import java.util.ArrayList;
////
////import static com.example.game.Level1.View.MainThread.canvas;
////
////public class GameManager {
////
////    protected static int gridHeight;
////    protected static int gridWidth;
////    protected ChildBall b;
////    protected Button left;
////    protected Button right;
////    Paint paintText = new Paint();
////    int score;
////    boolean flag = false;
////    String ballColor;
////    int points;
////    public static int finalScore=0;
////
////    ArrayList<Barrier> items = new ArrayList<Barrier>();
////
////    public GameManager(int height, int width, String ballColor, String points) {
////        gridHeight = height;
////        gridWidth = width;
////        paintText.setTextSize(60);
////        paintText.setTypeface(Typeface.DEFAULT_BOLD);
////        this.ballColor = ballColor;
////        if (points.equals("EASY"))
////            this.points = 10;
////        else
////            this.points = 15;
////        paintText.setColor(Color.WHITE);
////
////        score = 0;
////    }
////
////    public void createItems()
////    {
////        Barrier b1 = new Barrier(0);
////        items.add(b1);
////        Barrier b2 = new Barrier(10);
////        items.add(b2);
////        Barrier b3 = new Barrier(20);
////        items.add(b3);
////        Barrier b4 = new Barrier(30);
////        items.add(b4);
////
////        b = new ChildBall(15, 40, ballColor);
////
////        // button
////        left = new Button(Level1view.leftButtonImage, 100, 1800);
////        right = new Button(Level1view.rightButtonImage, 800, 1800);
////
////    }
////
////    public void update()
////    {
////        for(int i = 0; i<items.size();i++)
////        {
////            items.get(i).move();
////            Barrier temp = items.get(items.size()-1);
//////            if(temp.height*Level1view.charHeight == 1680)
////            if(temp.height == 39)
////            {
////                if(!temp.contains(b.x)) {
////                    this.flag = true;
////                    this.draw(Level1view.can);
////                    collision();
////                }
////            }
////        }
////        delete_and_add_barrier();
////    }
////
////    public void draw(Canvas canvas)
////    {
////
////        if(flag)
////        {
////            canvas.drawText("YOU LOSE", 400, 800, paintText);
////            Level1view.gameRunning = false;
////        }
////        else if(score < points) {
////            canvas.drawText("SCORE:" + this.score, 60, 55, paintText);
////        }
////        if(score == points)
////        {
////            canvas.drawText("YOU WON", 400, 800, paintText);
////            Level1view.gameRunning = false;
////        }
////
////        for(int i = 0; i<items.size(); i++)
////        {
////            items.get(i).draw(canvas);
////        }
////        b.draw(canvas);
////        left.draw(canvas);
////        right.draw(canvas);
////    }
////
////    public void delete_and_add_barrier()
////    {
////        for(int i=0;i<items.size();i++)
////        {
////            Barrier temp = items.get(i);
////            if(temp.height > 40)
////            {
////                removeBarrier(temp);
////                this.score += 1;
////                finalScore += 1;
////                add_barrier_at_top();
////            }
////        }
////    }
////
////    private void removeBarrier(Barrier b)
////    {
////        items.remove(b);
////    }
////
////    private void add_barrier_at_top()
////    {
////        int newBarrierHeight = items.get(0).height;
////        newBarrierHeight -= 10;
////        // Adds barrier at the top
////        Barrier b = new Barrier(newBarrierHeight);
////        items.add(0, b);
////    }
////
////    public void buttonPressed(int x, int y)
////    {
////        if(left.contains(x, y)) {
////            b.moveLeft();
////        }
////        else if(right.contains(x, y)) {
////            b.moveRight();
////        }
////    }
////
////    public void collision()
////    {
//////        Level1view.gameRunning = false;
////        finalScore = score;
////    }
////}
//package com.example.game.Level1;
//
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Typeface;
//
//import java.util.ArrayList;
//
///**
// * Manages how the game is run and displayed on the screen
// * */
//
//public class GameManager {
//
//    protected static int gridHeight;
//    protected static int gridWidth;
//    protected Ball b;
//    protected Button left;
//    protected Button right;
//    Paint paintText = new Paint();
//    boolean flag = false;
//    String ballColor;
//    int points;
//    public static int finalScore=0;
//
//    ArrayList<Barrier> items = new ArrayList<Barrier>();
//
//    public GameManager(int height, int width, String ballColor, String points) {
//        gridHeight = height;
//        gridWidth = width;
//        paintText.setTextSize(60);
//        paintText.setTypeface(Typeface.DEFAULT_BOLD);
//        this.ballColor = ballColor;
//        if (points.equals("EASY"))
//            this.points = 10;
//        else
//            this.points = 15;
//        paintText.setColor(Color.WHITE);
//
//    }
//
//    /**
//     * Creates the items displayed on the screen
//     */
//    public void createItems()
//    {
//        Barrier b1 = new Barrier(0);
//        items.add(b1);
//        Barrier b2 = new Barrier(10);
//        items.add(b2);
//        Barrier b3 = new Barrier(20);
//        items.add(b3);
//        Barrier b4 = new Barrier(30);
//        items.add(b4);
//
//        b = new Ball(15, 40, ballColor);
//
//        // button
//        left = new Button(Level1view.leftButtonImage, 100, 1800);
//        right = new Button(Level1view.rightButtonImage, 800, 1800);
//
//    }
//
//    /**
//     * Updates the state of the game objects.
//     * */
//    public void update()
//    {
//        for(int i = 0; i<items.size();i++)
//        {
//            items.get(i).move();
//            Barrier temp = items.get(items.size()-1);
//            if(temp.getHeight() == 39)
//            {
//                if(!temp.contains(b.getX())) {
//                    this.flag = true;
//                    this.draw(Level1view.can);
//                }
//            }
//        }
//        deleteAndAddBarrier();
//    }
//
//    /**
//     * Draws out the game objects on the canvas.
//     * @param canvas    where to draw the objects
//     */
//    public void draw(Canvas canvas)
//    {
//
//        if(flag)
//        {
//            canvas.drawText("YOU LOSE", 400, 800, paintText);
//            Level1view.gameRunning = false;
//        }
//        else if(finalScore < points) {
//            canvas.drawText("SCORE:" + finalScore, 60, 55, paintText);
//        }
//        if(finalScore == points)
//        {
//            canvas.drawText("YOU WON", 400, 800, paintText);
//            Level1view.gameRunning = false;
//        }
//
//        for(int i = 0; i<items.size(); i++)
//        {
//            items.get(i).draw(canvas);
//        }
//        b.draw(canvas);
//        left.draw(canvas);
//        right.draw(canvas);
//    }
//
//    /**
//     * Helper method to delete and add the barrier when gone from which have gone off the screen
//     */
//
//    private void deleteAndAddBarrier()
//    {
//        for(int i=0;i<items.size();i++)
//        {
//            Barrier temp = items.get(i);
//            if(temp.getHeight() > 40)
//            {
//                removeBarrier(temp);
//                finalScore += 1;
//                addBarrierAtTop();
//            }
//        }
//    }
//
//    /**
//     * Helper method to remove the barrier that have gone from the screen.
//     * @param b     barrier which has gone off the screen.
//     */
//    private void removeBarrier(Barrier b)
//    {
//        items.remove(b);
//    }
//
//    /**
//     * Helper to add the barrier to the top of the screen
//     */
//    private void addBarrierAtTop()
//    {
//        int newBarrierHeight = items.get(0).getHeight();
//        newBarrierHeight -= 10;
//        // Adds barrier at the top
//        Barrier b = new Barrier(newBarrierHeight);
//        items.add(0, b);
//    }
//
//    /**
//     * Responds to the button either left or right button pressed.
//     *
//     * @param x     the x coordinate of the tap
//     * @param y     the y coordinate of the tap
//     */
//    public void buttonPressed(int x, int y)
//    {
//        if(left.contains(x, y)) {
//            b.moveLeft();
//        }
//        else if(right.contains(x, y)) {
//            b.moveRight();
//        }
//    }
//}
package com.example.game.Level1.Entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import androidx.annotation.NonNull;

import com.example.game.Level1.View.Level1view;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Manages how the game is run and displayed on the screen
 * */

public class GameManager implements ValueEventListener {

    protected static int gridHeight;
    protected static int gridWidth;
    private Ball b;
    //private Button left;
   // private Button right;
    private Paint paintText = new Paint();
    private boolean flag = false;
    private String ballColor;
    private int points;
    private int livesLeft;
    private ArrayList<Life> lives = new ArrayList<>();
    public static int finalScore=0;
   // private Game1Presenter presenter;
    private ArrayList<Barrier> items = new ArrayList<>();
    float x, y;
    private DatabaseReference reference;
    boolean checker;
    private ArrayList <Integer> hidden = new ArrayList<>();
    private ArrayList<Integer> hiddenChecker = new ArrayList<>();
    private Canvas canvas;
    int totalBarriersAdded;


    public GameManager(int height, int width, String points, String ballColor, String username){//, Game1Presenter presenter) {
         this.x = 500;
//        this.y = 1600;
        checker = true;
        hidden.add(1);
        hidden.add(2);
        hidden.add(4);

        gridHeight = height;
       // this.presenter = presenter;
        this.reference = FirebaseDatabase.getInstance().getReference().child(username);
        gridWidth = width;
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        this.livesLeft = 3;
        this.ballColor = ballColor;
        if (points.equals("EASY"))
            this.points = 15;
        else
            this.points = 20;
        paintText.setColor(Color.WHITE);
        Life heart1 = new Life(Level1view.heart, 800, 0);
        lives.add(heart1);
        Life heart2 = new Life(Level1view.heart, 870, 0);
        lives.add(heart2);
        Life heart3 = new Life(Level1view.heart, 940, 0);
        lives.add(heart3);
        this.totalBarriersAdded = 0;
    }

    /**
     * Creates the items displayed on the screen
     */
   public void createItems()
    {
        if(this.totalBarriersAdded < 5)
        {
            Barrier b1 = new Barrier(0, "WB");
            items.add(b1);
            Barrier b2 = new Barrier(10, "WB");
            items.add(b2);
            Barrier b3 = new Barrier(20, "WB");
            items.add(b3);
            Barrier b4 = new Barrier(30, "WB");
            items.add(b4);
            this.totalBarriersAdded += 4;
        }
        else if(this.totalBarriersAdded >= 10)
        {
            Barrier b1 = new Barrier(0, "YB");
            items.add(b1);
            Barrier b2 = new Barrier(10, "YB");
            items.add(b2);
            Barrier b3 = new Barrier(20, "YB");
            items.add(b3);
            Barrier b4 = new Barrier(30, "YB");
            items.add(b4);
            this.totalBarriersAdded += 4;
        }
        else if(this.totalBarriersAdded >= 5)
        {
            Barrier b1 = new Barrier(0, "BB");
            items.add(b1);
            Barrier b2 = new Barrier(10, "BB");
            items.add(b2);
            Barrier b3 = new Barrier(20, "BB");
            items.add(b3);
            Barrier b4 = new Barrier(30, "BB");
            items.add(b4);
            this.totalBarriersAdded += 4;
        }


        b = new Ball(100, 1700, ballColor);
        // button
       // left = new Button(Level1view.leftButtonImage, 100, 1800);
        //right = new Button(Level1view.rightButtonImage, 800, 1800);

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
                // checks if the ball collides

                if(!temp.contains((int)this.x)) {
                    System.out.println((int)this.x);
                    if(this.livesLeft == 1) {
                        this.flag = true;
                        int lastScore = hiddenChecker.get(hiddenChecker.size() -1);
                        hiddenChecker.add(finalScore - lastScore);
                        System.out.println(hiddenChecker);
                        System.out.println(hidden);
                        if (hiddenChecker.equals(hidden)){

                            this.flag = false;
                            finalScore = points;

                        }
                        System.out.println(flag);

                        this.draw(canvas);
                    }
                    else{
                        this.livesLeft -= 1;
                        if (hiddenChecker.size()== 0){
                            hiddenChecker.add(finalScore);
                            System.out.println(hiddenChecker);
                        }
                        else{
                            int lastScore = hiddenChecker.get(hiddenChecker.size() -1);
                            hiddenChecker.add(finalScore - lastScore);
                            System.out.println(hiddenChecker);

                        }

                        lives.remove(0);
                        this.items.clear();
                        createItems();
                    }
                }
            }
        }
        deleteAndAddBarrier();
    }
    public boolean stopGame(){
        return checker;
    }

    /**
     * Draws out the game objects on the canvas.
     * @param canvas    where to draw the objects
     */
    public boolean draw(Canvas canvas)

    {   this.canvas = canvas;
        if(flag)
        {
            canvas.drawText("YOU LOSE", 400, 800, paintText);
            checker = false;
            this.reference.addValueEventListener(this);
           // Level1view.gameRunning = false;
        }
        else if(finalScore < points) {
            canvas.drawText("SCORE:" + finalScore, 60, 55, paintText);
        }
        if(finalScore == points)
        {
            canvas.drawText("YOU WON", 400, 800, paintText);
            this.reference.addValueEventListener(this);
            checker = false;
            //Level1view.gameRunning = false;
            return true;

           // presenter.moveToNextGame();




        }

        for(int i = 0; i<items.size(); i++)
        {
            items.get(i).draw(canvas);
        }

        b.draw(canvas, x);
        //left.draw(canvas);
        //right.draw(canvas);
        lives.get(0).draw(canvas);
        for(Life l:lives)
        {
            l.draw(canvas);
        }
        return false;
    }

    /**
     * Helper method to delete and add the barrier when gone from which have gone off the screen
     */

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        Long oldScore = (Long) dataSnapshot.child("level1").getValue();
        try {
            if (oldScore < this.finalScore)
                this.reference.child("level1").setValue(this.finalScore);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

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
                this.totalBarriersAdded +=1;
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
        float newBarrierHeight = items.get(0).getHeight();
        newBarrierHeight -= 10;
        // Adds barrier at the top
        Barrier b = null;
        if(this.totalBarriersAdded < 5)
        {
            b = new Barrier(newBarrierHeight,"WB");
        }
        else if(this.totalBarriersAdded >= 10){
            b = new Barrier(newBarrierHeight, "YB");
        }
        else if(this.totalBarriersAdded >= 5)
        {
            b = new Barrier(newBarrierHeight, "BB");
        }
        items.add(0, b);
    }

    /**
     * Responds to the button either left or right button pressed.
     *
     * @param x     the x coordinate of the tap
     //* @param y     the y coordinate of the tap
     *
     */

    public void ballMove(float x)
    {
        setX(x);
       // this.y = y;

//        if(left.contains(x, y)) {
//            b.moveLeft();
//        }
//        else if(right.contains(x, y)) {
//            b.moveRight();
//        }
    }

    private void setX(float x) {
        this.x = x;
    }
}
