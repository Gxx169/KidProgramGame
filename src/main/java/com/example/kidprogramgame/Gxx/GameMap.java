package com.example.kidprogramgame.Gxx;

import javafx.scene.canvas.Canvas;

//抽象游戏地图类
public abstract class GameMap {

    //可活动范围
    private int max_x,max_y,min_x,min_y;
    private Canvas canvas;
    //地图信息
    private int[][] mapInform;

    public GameMap(){
        canvas = new Canvas(Constant.mapWidth, Constant.mapHeight);
        mapInform = new int[Constant.blockNum][Constant.blockNum];

    }

    public abstract void initMapInform();

    public Canvas getMapCanvas(){
        return canvas;
    }

    public int[][] getMapInform() {
        return mapInform;
    }


    //接受访问者，画家
    void drawMap(Painter painter) {
        //画家访问游戏地图的画布和地图信息，在画布上根据地图信息进行绘制
        painter.draw(getMapCanvas(),getMapInform());
    }
    //刷新地图
    void refresh() {
        initMapInform();
        Painter painter = new Painter();
        painter.draw(getMapCanvas(),getMapInform());
    }
    //更新地图
    void update(){
        Painter painter = new Painter();
        painter.draw(getMapCanvas(),getMapInform());
    }

    public int getMax_x() {
        return max_x;
    }

    public void setMax_x(int max_x) {
        this.max_x = max_x;
    }

    public int getMax_y() {
        return max_y;
    }

    public void setMax_y(int max_y) {
        this.max_y = max_y;
    }

    public int getMin_x() {
        return min_x;
    }

    public void setMin_x(int min_x) {
        this.min_x = min_x;
    }

    public int getMin_y() {
        return min_y;
    }

    public void setMin_y(int min_y) {
        this.min_y = min_y;
    }
}
