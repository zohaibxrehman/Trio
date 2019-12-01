package com.example.game.Level2.Model;

public class GameMode1 implements Algorithms {

    MakeObjects objects;
    private int score;
    private boolean gameOver;
    private int tries;

    public GameMode1(MakeObjects objects, int tries){
        this.objects = objects;
        this.score = 0;
        this.gameOver = false;
        this.tries = tries;
    }

    @Override
    public void buttonPressed(float x, float y) {
        if (!this.gameOver){
            for (LeftBall b: objects.getLeft()){
                if (b.contains(x, y) && !b.getTouched()) {
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
        }
    }

    @Override
    public String getScore() {
        return(Integer.toString(score));
    }

    public int getTries(){
        return this.tries;
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
