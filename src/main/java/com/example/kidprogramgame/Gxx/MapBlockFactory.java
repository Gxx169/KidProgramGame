package com.example.kidprogramgame.Gxx;

import java.util.HashMap;
import java.util.Map;

//地图快工厂  这里使用了简单工厂，单例模式和享元模式
public class MapBlockFactory {
    //工厂单例，使用饿汉式
    private static MapBlockFactory  instance = new MapBlockFactory();
    //地图块享元池
    private Map<Integer,MapBlock> blockPool;
    private MapBlockFactory(){
        blockPool = new HashMap<>();
    }

    //获取地图快对象
    public MapBlock getMapBlock(int i){
        MapBlock mapBlock = null;
        //如果享元池中存在则直接从享元池中获取
        if(blockPool.containsKey(i)){
            mapBlock = blockPool.get(i);
        }
        //不存在则实例化对象，存入享元池
        else{
            switch (i){
                case 0:
                    mapBlock = new LandBlock();
                    break;
                case 1:
                    mapBlock = new HoleBlock();
                    break;
                case 2:
                    mapBlock = new WaterBlock();
                    break;
                case 3:
                    mapBlock = new HomeBlock();
                    break;
                case 4:
                    mapBlock = new StarBlock();
                    break;
            }
            blockPool.put(i,mapBlock);
        }
        return mapBlock;
    }
    //获取地图块工厂实例
    public static MapBlockFactory getInstance() {
        return instance;
    }
}
