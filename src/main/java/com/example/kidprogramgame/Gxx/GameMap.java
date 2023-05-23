package com.example.kidprogramgame.Gxx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class GameMap {
    static final String imageRes = "file:src/main/resources/com/example/kidprogramgame/image/";
    Canvas canvas;
    GraphicsContext gc;
    int width = 640;
    int height = 640;
    GameMap(){
        canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
    }

    public abstract Canvas getMapCanvas();
    public abstract void down() throws InterruptedException;
}
