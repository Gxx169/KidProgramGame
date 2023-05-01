package com.example.kidprogramgame.Gxx;

import com.example.kidprogramgame.Gxx.MapComponent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.Map;

public class MapDrawer {
    // 一个二维数组，表示要绘制的地图
    private int[][] map;
    // 每个数字对应的地块
    private Map<Integer, MapComponent> tilemap;
    // 传入绘制的对象
    private Canvas canvas;
    private GraphicsContext gc;

    public MapDrawer(int[][] map, Map<Integer, MapComponent> tilemap, Canvas canvas, GraphicsContext gc){
        this.map = map;
        this.tilemap = tilemap;
        this.canvas = canvas;
        this.gc = gc;
    }


    // 绘制
    public void drawmap(){
        // 计算每个快的长宽
        int tile_height = (int)canvas.getWidth() / map[0].length;
        int tile_width = (int)canvas.getHeight() / map.length;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(!tilemap.containsKey(map[i][j])){
                    throw new RuntimeException("粗问题啦，没有这个地块啦");
                }
                MapComponent map = tilemap.get(this.map[i][j]);
                gc.drawImage(map.getImage(), i*tile_height, j*tile_width, map.getWidth(), map.getHeight());

            }
        }
    }

}
