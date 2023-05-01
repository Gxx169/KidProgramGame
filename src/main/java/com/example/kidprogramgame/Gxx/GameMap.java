package com.example.kidprogramgame.Gxx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class GameMap {
    Canvas canvas;
    String name;
    String name2;
    GraphicsContext gc;
    GameMap(){
        canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();
    }

    public abstract Canvas getMapCanvas();
}
