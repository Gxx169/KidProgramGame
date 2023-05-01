package com.example.kidprogramgame.Gxx;

import javafx.scene.canvas.Canvas;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OneMap extends GameMap{
    public OneMap() {

    }
    @Override
    public Canvas getMapCanvas() {
        int width = 100;
        int height = 100;

        System.out.println("ss");

        MapComponent map1 = new MapComponent("file:src/main/resources/com/example/kidprogramgame/image/山地.png", height, width);

        Map<Integer, MapComponent> tilemap = new HashMap<>();
        tilemap.put(1, map1);
        tilemap.put(2, map1);
        tilemap.put(3, map1);
        tilemap.put(4, map1);
        tilemap.put(5, map1);

        int num = 6;

        int[][] map = new int[num][num];
        Random random = new Random();
        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                map[i][j] = random.nextInt(5)+1;
            }
        }

        MapDrawer mapDrawer = new MapDrawer(map, tilemap, canvas, gc);
        mapDrawer.drawmap();

        return canvas;
    }
}
