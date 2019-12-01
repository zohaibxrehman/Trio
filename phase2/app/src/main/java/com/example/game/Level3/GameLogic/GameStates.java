package com.example.game.Level3.GameLogic;

import com.example.game.Level3.Entities.Ball;
import com.example.game.Level3.GameElements.GameElements;
import com.example.game.Level3.Sound.SoundFacade;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

class GameStates {
    void memoriseState(GameElements gameElements, SoundFacade soundFacade){
        if (!gameElements.hiddenState) {
            if (gameElements.showCount == gameElements.time) {
                for (Ball b : gameElements.balls) {
                    b.hide();
                    gameElements.memoryBall.show();
                    soundFacade.whooshSound.start();
                }
                gameElements.hiddenState = true;
            } else if (gameElements.showCount < gameElements.time) {
                gameElements.showCount++;
            }
        }
    }

    void rememberState(float touchX, float touchY, GameElements gameElements, SoundFacade soundFacade) {
        if (gameElements.hiddenState) {
            for (Ball ball : gameElements.balls) {
                if (ball.contains(touchX, touchY) && !ball.isTouched()) {
                    ball.show();
                    ball.setTouched(true);

                    if (ball.equals(gameElements.memoryBall)) {
                        gameElements.score++;
                        gameElements.numberOfRefreshes = gameElements.numberOfRefreshes + 1;
                        levelUp(gameElements, soundFacade);
                        System.out.println("Success!");
                        soundFacade.success.start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        resetGame(gameElements, soundFacade);
                    } else {
                        gameElements.lives--;
                        soundFacade.failure.start();
                    }
                }
            }
        }
    }

    private void levelUp(GameElements gameElements, SoundFacade soundFacade){
        if (gameElements.numberOfRefreshes % 3 == 0) {
            gameElements.level++;
            gameElements.score++;
            if (gameElements.lives == 6) {
                gameElements.lives = gameElements.lives + 1;
                soundFacade.boost.start();
            } else if (gameElements.lives == 5) {
                gameElements.lives = gameElements.lives + 2;
                soundFacade.boost.start();
            } else if (gameElements.lives <= 4) {
                gameElements.lives = gameElements.lives + 3;
                soundFacade.boost.start();
            }
        }
        if (gameElements.numberOfRefreshes % 6 == 0){
            gameElements.score++;
            gameElements.lives = 7;
            soundFacade.boost.start();
        }
    }

    private void resetGame(GameElements gameElements, SoundFacade soundFacade){
        gameElements.showCount = 0;
        gameElements.hiddenState = false;

        Collections.shuffle(gameElements.bitmapColours);
        for(int i = 0; i < 9; i++) {
            gameElements.balls.get(i).changeColour(gameElements.bitmapColours.get(i));
            gameElements.balls.get(i).show();
            gameElements.balls.get(i).setTouched(false);
        }
        gameElements.memoryBall.changeColour(gameElements.bitmapColours.get(ThreadLocalRandom.current().nextInt(0, 9)));
        gameElements.memoryBall.hide();
        soundFacade.whooshSound.start();
    }
}
