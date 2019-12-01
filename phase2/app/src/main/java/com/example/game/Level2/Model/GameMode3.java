package com.example.game.Level2.Model;

import java.util.ArrayList;
import java.util.List;

public class GameMode3 implements Algorithms {

    MakeObjects objects;
    private int tries;
    private int score;
    private double percent;
    private boolean gameOver;
    private List<LeftBall> pressed;

    public GameMode3(MakeObjects objects, int tries){
        this.objects = objects;
        this.tries = 0;
        this.score = 0;
        this.percent = 0.0;
        this.gameOver = false;
        this.tries = tries;
        pressed = new ArrayList<>();

    }

    @Override
    public void buttonPressed(float x, float y) {
        if (!this.gameOver){
            for (LeftBall b: objects.getLeft()){
                if (b.contains(x, y) && !b.getTouched()) {
                    b.setTouched();
                    b.setColor();
                    pressed.add(b);
                    if(b.getIsTarget() | b.getPair().getIsTarget()){
                        score++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        resetGame();
                    }else{
                        tries--;
                    }
                    if (score == 7){
                        this.gameOver = true;
                    }
                }
            }
        }
    }

    public void undo(){
        this.gameOver = false;
        this.tries = 1;
        LeftBall b = this.pressed.get(pressed.size() - 1);
        b.undo();
    }

    @Override
    public String getScore() {
        percent = (score * 1.0) / (tries * 1.0) * 100;
        String returnValue = Double.toString(percent);
        returnValue += "%";
        return returnValue;
    }

    public int getTries(){
        return this.tries;
    }

    @Override
    public boolean getGameOver() {
        return this.gameOver;
    }

    @Override
    public void resetGame() {
        pressed = new ArrayList<>();
        objects.resetGame();
    }
}
