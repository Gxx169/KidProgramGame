package com.example.kidprogramgame.Gxx;

//抽象建造者
public abstract class LevelBuilder {

    protected Level level = new Level();
    //建造角色
    public abstract void buildRole();
    //建造地图
    public abstract void buildMap();
    //将角色和地图导入关卡面板
    public abstract void load();
    //获取关卡
    public Level getLevel() {
        buildRole();
        buildMap();
        load();
        return level;
    }
}
