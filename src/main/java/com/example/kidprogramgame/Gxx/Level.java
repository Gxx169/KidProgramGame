package com.example.kidprogramgame.Gxx;

import javafx.scene.layout.StackPane;

public class Level implements Action{
    private Role role;
    private StackPane mapPane;
    private GameMap gameMap;

    Level(){
        mapPane = new StackPane();
        mapPane.setPrefSize(Constant.mapWidth,Constant.mapHeight);
    }
    @Override
    public void toUp() {

    }

    @Override
    public void toLeft() {

    }

    @Override
    public void toRight() {

    }

    @Override
    public void toDown() {

    }
    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setMapPane(StackPane mapPane) {
        this.mapPane = mapPane;
    }

    public StackPane getMapPane() {
        return mapPane;
    }
}
