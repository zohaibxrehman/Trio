package com.example.game.Level1.Entities;

import java.util.ArrayList;

public class GameMode1 implements Algorithms {
    GameMode1(){}
    @Override
    public void createBarriers(ArrayList<Barrier> items) {
            Barrier b1 = new Barrier(0, "WB");
            items.add(b1);
            Barrier b2 = new Barrier(10, "WB");
            items.add(b2);
            Barrier b3 = new Barrier(20, "WB");
            items.add(b3);
            Barrier b4 = new Barrier(30, "WB");
            items.add(b4);
    }

    @Override
    public Barrier addBarrierAtTop(Barrier b, float newBarrierHeight) {
        b = new Barrier(newBarrierHeight,"WB");
        return b;
    }
}
