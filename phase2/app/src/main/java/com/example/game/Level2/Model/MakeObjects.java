package com.example.game.Level2.Model;

import android.graphics.Color;
import android.util.Pair;

import com.example.game.Level2.Presenter.DrawObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeObjects {

    private List<RightBall> right;

    private List<LeftBall> left;
    private List<Drawable> allObjects;
    private List<Line> lines;
    private int difficulty;

    public MakeObjects(int difficulty){
        this.difficulty = difficulty;
        right = new ArrayList<>();
        left = new ArrayList<>();
        lines = new ArrayList<>();
        allObjects = new ArrayList<>();
        makeBalls(difficulty);
        makePairs();
        setTarget();
        makeLines();
    }

    private void makeBalls(int number) {
        int count = 300;
        for (int i = number; i > 0; i--) {
            LeftBall b = new LeftBall(200, count, Color.BLUE);
            RightBall pair = new RightBall(900, count, Color.BLUE);
            right.add(pair);
            left.add(b);
            allObjects.add(pair);
            allObjects.add(b);
            count += 400;
        }
    }

    private int randomizeBounds(int bounds){
        return (int) (Math.random() * (bounds - 350)) + 350;
    }

    private void makeLines() {
        List<Pair> coords = new ArrayList<>();
        int x1, x2, y1, y2;
        for (LeftBall b : left) {
            while (true) {
                x1 = randomizeBounds(751);
                y1 = randomizeBounds(1751);
                x2 = randomizeBounds(751);
                y2 = randomizeBounds(1751);
                Pair c1 = Pair.create(x1, y1);
                Pair c2 = Pair.create(x2, y2);
                if (x1 < (x2 - 50) && Math.abs(y1 - y2) >= 100 &&
                        !coords.contains(c1) && !coords.contains(c2)) {
                    break;
                }
            }
            coords.add(Pair.create(x1, y1));
            coords.add(Pair.create(x2, y2));
            Line l1 = new Line(b.getX() + 50, b.getY(), x1, y1, Color.BLUE);
            Line l2 = new Line(x1, y1, x2, y2, Color.BLUE);
            Line l3 = new Line(x2, y2, b.getPair().getX(), b.getPair().getY(), Color.BLUE);
            List<Line> createdLines = Arrays.asList(l1, l2, l3);
            lines.addAll(createdLines);
            allObjects.addAll(createdLines);

        }
    }
    private void setTarget() {
        int r = (int) (Math.random() * right.size());
        RightBall b1 = right.get(r);
        b1.setTarget();
        b1.getPair().setTarget();
    }

    private void makePairs() {

        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(0,1,2,3));
        int r;
        for (LeftBall b : left) {
            r = (int) (Math.random() * (ints.size()));
            RightBall b1 = right.get(ints.get(r));
            ints.remove(r);
            b.setPair(b1);
            b1.setPair(b);
        }
    }

    public List<RightBall> getRight() {
        return right;
    }

    public List<LeftBall> getLeft() {
        return left;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Drawable> getAllObjects(){return allObjects;}

    public void resetGame(){
        left = new ArrayList<>();
        right = new ArrayList<>();
        lines = new ArrayList<>();
        allObjects = new ArrayList<>();
        makeBalls(difficulty);
        makePairs();
        setTarget();
        makeLines();
    }
}
