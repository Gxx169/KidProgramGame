package com.example.kidprogramgame.Gxx;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

//关卡类，实现了提供给游戏主体的方法
public class Level implements Action{
    private Role role;
    private Pane mapPane;
    private GameMap gameMap;

    Level(){
        mapPane = new Pane();
        mapPane.setPrefSize(Constant.mapWidth,Constant.mapHeight);
    }
    @Override
    public void toUp() {
        role.toUp();
    }

    @Override
    public void toLeft() {
        role.toLeft();
    }

    @Override
    public void toRight() {
        role.toRight();
    }

    @Override
    public void toDown() {
        role.toDown();
    }
    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Pane getMapPane() {
        return mapPane;
    }
    public void load(){
        mapPane.getChildren().addAll(gameMap.getMapCanvas(),role);
    }

    public int check(){


        return 0;
    }
}
