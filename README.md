We created three games for our CSC207 project using Android Studio. The focus of the assignment was to make good use of design principles, patterns and architecture. 

```
Frontend - XML
Backend - Java
Database - Firebase
```
<img src="https://i.imgur.com/HPaVron.jpg" width="250">

**Game 1: The Labyrinth**
Info: In this game we have a bunch of barriers and a ball. The basic purpose of the game to get the
ball through the barrier or avoid it. In this game we have 3 lives for the player.
We have 3 sub game for this game -

    *Level 1*: In this level, we have to dodge the barriers that appear on the screen.

    *Level 2*: In this level, we have to go through on top of a single barrier that appears on the screen.

    *Level 3*: In this level, we have to go through two barriers that appear on the screen.

We have an easter egg in this game: If you lose your lives on score 1, 3 and 6, then you win the game!
The other way to win the a game is score 15 points in that if selected 'easy' mode or 20 if selected
'hard mode'.

We are applying the Strategy design pattern by using Algorithm interface to decrease coupling and
increase cohesion.

<img src="https://i.imgur.com/ov6d62b.jpg" width="250">

**Game 2: The Matching Game**
Info: In this game the goal is to click the ball on the left that matches certain ones on the right
If you select hard mode you will have 5 tries (incorrect answers) and default easy mode is 7 tries

    *Mode 1*: Click the ball on the left that matches the yellow one on the right, score 7 to win

    *Mode 2*: Click the balls on the left that DO NOT match the yellow one on the right, score 15 to
    win

    *Mode 3*: Just like game mode, but the stat tracked is accuracy get 60% accuracy after at least 5
    clicks on the ball to win

<img src="https://i.imgur.com/esc2nLy.jpg" width="250">

**Game 3: The Memory Game**
In this game the user is first shown 9 colored balls for a short duration.
They should be memorise the position of these colored balls. After this short duration, they will be
prompted with one of those colored balls. The player should now select the position of the ball
where this colour had initially appeared and they receive a point.

```
*Levels*: For every 3 correct answers, the level increases. When the level goes up, the player is given at
most 3 extra lives(if they had lost any) and an extra point. The difficulty of the game increases,ie,
they are given fewer time to complete each stages of the next level.
Every 6 correct answers, the user gains back all their lives and get 2 extra points.

*Lives*: The user is given 7 lives which appear as hearts in the game. This means they can make at
most 7 wrong attempts. They gain back lives as they complete levels.

*Easter Egg*: If the player selects the 4 corner balls in such a way that they end up having only 1
life left then they will be granted with 25 extra points and all of their lives back!
```

<img src="https://i.imgur.com/PkKDthT.jpg" width="250">
