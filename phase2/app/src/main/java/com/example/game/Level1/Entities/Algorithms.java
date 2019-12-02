package com.example.game.Level1.Entities;

import java.util.ArrayList;

/**
 * The interface to creating barriers specific to the type mentioned.
 */
public interface Algorithms {
    void createBarriers(ArrayList<Barrier> items);

    Barrier addBarrierAtTop(float newBarrierHeight);
}
