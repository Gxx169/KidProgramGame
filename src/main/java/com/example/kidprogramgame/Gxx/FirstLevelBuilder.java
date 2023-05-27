package com.example.kidprogramgame.Gxx;

//具体的建造者
public class FirstLevelBuilder extends LevelBuilder{

    //第一个关卡建造者，建造关卡的各个部分
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
