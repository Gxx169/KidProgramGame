package com.example.kidprogramgame.Gxx;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

//关卡类，实现了提供给游戏主体的方法
public class Level implements Action{
    private Role role;
    private Pane levelPane;
    private GameMap gameMap;

    Level(){
        levelPane = new Pane();
        levelPane.setPrefSize(Constant.mapWidth,Constant.mapHeight);
    }

    @Override
    public int getSate(){
        role.show();
        int x = role.getMyX();
        int y = role.getMyY();
        if(x>9||x<0||y>9||y<0){
            return -1;
        }
        switch (gameMap.getMapInform()[x][y]){
            //在陆地
            case 0:
                return 0;
            //陷阱
            case 1:
                return 1;
            //水
            case 2:
                return 2;
            //家
            case 3:
                return 3;
        }
        return 0;
    }

    @Override
    public void refreshMap(){
        gameMap.refresh();
    }
    @Override
    public void reStart(){
        role.back();
        refreshMap();
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

    public Pane getLevelPane() {
        return levelPane;
    }
    public void load(){
        levelPane.getChildren().addAll(gameMap.getMapCanvas(),role);
    }

}
