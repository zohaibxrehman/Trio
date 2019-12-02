package com.example.game.Level2.Presenter;


import android.graphics.Canvas;

import com.example.game.Level2.Model.Drawable;
import com.example.game.Level2.Model.MakeObjects;

public class DrawObjects {
    public void draw(Canvas canvas, MakeObjects makeObjects) {
        for (Drawable allObjects : makeObjects.getAllObjects()) {
            allObjects.draw(canvas);
        }
    }

    void undoButton(Canvas canvas, MakeObjects makeObjects) {
        for (Drawable undo : makeObjects.getUndoObject()) {
            undo.draw(canvas);
        }
    }
}
