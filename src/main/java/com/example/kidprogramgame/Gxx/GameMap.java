package com.example.kidprogramgame.Gxx;

import javafx.scene.canvas.Canvas;

public abstract class GameMap {

    private Canvas canvas;

    private int[][] mapInform;

    public GameMap(){
        canvas = new Canvas(Constant.mapWidth, Constant.mapHeight);
        mapInform = new int[Constant.blockNum][Constant.blockNum];
    }

    public Canvas getMapCanvas(){
        return canvas;
    }
    public abstract void initMapInform();

    public int[][] getMapInform() {
        return mapInform;
    }
}
