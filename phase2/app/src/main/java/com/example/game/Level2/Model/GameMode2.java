package com.example.game.Level2.Model;

public class GameMode2 implements Algorithms {

    MakeObjects objects;
    private int score;
    private boolean gameOver;
    private int targets;
    private int tries;

    public GameMode2(MakeObjects objects, int tries){
        this.objects = objects;
        this.score = 0;
        this.gameOver = false;
        int targets = 0;
        this.tries = tries;
    }

    @Override
    public void buttonPressed(float x, float y) {
        if (!this.gameOver){
            for (LeftBall b: objects.getLeft()){
                if (b.contains(x, y) && !b.getTouched()) {
                    b.setTouched();
                    if (!b.getIsTarget()){
                        targets++;
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
                if (targets == 3){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resetGame();
                }
            }
        }
    }

    public int getTries(){
        return this.tries;
    }

    @Override
    public void resetGame() {
        targets = 0;
        objects.resetGame();}

    @Override
    public String getScore() {
        return Integer.toString(score);
    }

    @Override
    public boolean getGameOver() {
        return this.gameOver;
    }
}
