package com.example.game.Level2.Model;

public class GameMode1 implements Algorithms {

    MakeObjects objects;
    private int tries;
    private int score;
    private double percent;
    private boolean gameOver;

    public GameMode1(MakeObjects objects){
        this.objects = objects;
        this.tries = 0;
        this.score = 0;
        this.percent = 0.0;
        this.gameOver = false;
    }


    @Override
    public void buttonPressed(float x, float y) {
        if (!this.gameOver){
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
                    if (score == 7){
                        this.gameOver = true;
                    }
                }
            }
            percent = (score * 1.0) / (tries * 1.0) * 100;
        }
    }

    @Override
    public int getTries() {
        return this.tries;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public double getPercent() {
        return this.percent;
    }

    @Override
    public void resetGame() {
        objects.resetGame();
    }

    @Override
    public boolean getGameOver(){
        return this.gameOver;
    }
}
