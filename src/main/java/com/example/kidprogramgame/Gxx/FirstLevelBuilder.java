package com.example.kidprogramgame.Gxx;

public class FirstLevelBuilder extends LevelBuilder{
    @Override
    public void buildRole() {
        System.out.println("创建Role");
        Role r = new Role();
        level.setRole(r);
    }

    @Override
    public void buildMap() {
        System.out.println("创建Map");
        GameMap map = new RectMap();
        Painter painter = new Painter();
        painter.draw(map.getMapCanvas(),map.getMapInform());
        level.setGameMap(map);
    }

    @Override
    public void load() {
        level.load();
    }
}
