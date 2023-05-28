package com.example.kidprogramgame.Gxx;

public class SecondLevelBuilder extends LevelBuilder{
    @Override
    public void buildRole() {
        System.out.println("创建Role");
        Role r = new Role(0,9);
        level.setRole(r);
    }

    @Override
    public void buildMap() {
        System.out.println("创建Map");
        GameMap map = new RectMap();
        Painter painter = new Painter();
        //GameMap接受访问者Painter
        map.drawMap(painter);
        level.setGameMap(map);
    }

    //将角色和地图装入面板中
    @Override
    public void load() {
        level.load();
    }
}
