package com.example.game.Level2.Model;

public class GameMode2 implements Algorithms {

    MakeObjects objects;
    private int tries;
    private int score;
    private double percent;
    private boolean gameOver;
    private int targets;

    public GameMode2(MakeObjects objects){
        this.objects = objects;
        this.tries = 0;
        this.score = 0;
        this.percent = 0.0;
        this.gameOver = false;
        int targets = this.objects.getLeft().size();
    }

    @Override
    public void buttonPressed(float x, float y) {
        if (!this.gameOver){
            for (LeftBall b: objects.getLeft()){
                if (b.contains(x, y) && !b.getTouched()) {
                    tries++;
                    b.setTouched();
                    if (!b.getIsTarget()){
                        targets--;
                        score++;
                        b.setGreen();
                    }
                    else{
                        b.setRed();
                    }
                    if(b.getIsTarget() | b.getPair().getIsTarget()){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        resetGame();
                    }
                    if (score == 15){
                        this.gameOver = true;
                    }
                }
            }
            percent = (score * 1.0) / (tries * 1.0) * 100;
        }
    }

    @Override
    public void resetGame() {

    }

    @Override
    public int getScore() {
        return this.score;
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
    public boolean getGameOver() {
        return this.gameOver;
    }
}
