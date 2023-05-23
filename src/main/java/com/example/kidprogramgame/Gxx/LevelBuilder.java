package com.example.kidprogramgame.Gxx;

public abstract class LevelBuilder {

    protected Level level = new Level();

    public abstract void buildRole();
    public abstract void buildMap();
    public abstract void load();

    public Level getLevel() {
        buildRole();
        buildMap();
        load();
        return level;
    }
}
