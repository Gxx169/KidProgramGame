package com.example.kidprogramgame.Gxx;

import javafx.scene.layout.Pane;

//为游戏地图主体部分提供的接口
public interface Action {
    void toUp();
    void toLeft();
    void toRight();
    void toDown();
    void reStart();
    void refreshMap();

    int getSate();

    Pane getLevelPane();

    int getScores();

}
