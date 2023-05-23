package com.example.kidprogramgame.Gxx;

import java.util.HashMap;
import java.util.Map;

public class MapBlockFactory {
    private static MapBlockFactory  instance = new MapBlockFactory();
    private Map<Integer,MapBlock> blockPool;
    private MapBlockFactory(){
        blockPool = new HashMap<>();
    }
    public MapBlock getMapBlock(int i){
        MapBlock mapBlock = null;
        if(blockPool.containsKey(i)){
            mapBlock = blockPool.get(i);
        }
        else{
            switch (i){
                case 0:
                    mapBlock = new LandBlock();
                    blockPool.put(i,mapBlock);
                    break;
                case 1:
                    mapBlock = new HoleBlock();
                    blockPool.put(i,mapBlock);
                    break;
                case 2:
                    mapBlock = new WaterBlock();
                    blockPool.put(i,mapBlock);
                    break;
            }
        }
        return mapBlock;
    }

    public static MapBlockFactory getInstance() {
        return instance;
    }
}
