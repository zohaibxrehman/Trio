package com.example.game.Level2.Model;

public class GameMode1 implements Algorithms {

    MakeObjects objects;
    private int tries;
    private int score;
    private double percent;

    public GameMode1(MakeObjects objects){
        this.objects = objects;
        this.tries = 0;
        this.score = 0;
        this.percent = 0.0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getTries() {
        return this.tries;
    }

    @Override
    public double getPercent() {
        return this.percent;
    }


    @Override
    public void buttonPressed(float x, float y) {
        for (LeftBall b: objects.getLeft()){
            if (b.contains(x, y) && !b.getTouched()) {
                tries++;
                b.setTouched();
                b.setColor();
                if(b.getIsTarget() | b.getPair().getIsTarget()){
                    score++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resetGame();
                }
            }
        }
        percent = (score * 1.0) / (tries * 1.0) * 100;
    }

    @Override
    public void resetGame() {
        objects.resetGame();
    }
}
