package com.example.game.Level1.Entities;

import java.util.ArrayList;

public interface Algorithms {
    void createBarriers(ArrayList<Barrier> items);

    Barrier addBarrierAtTop(Barrier b, float newBarrierHeight);
}
