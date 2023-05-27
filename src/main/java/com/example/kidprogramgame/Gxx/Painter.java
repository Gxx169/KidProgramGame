package com.example.kidprogramgame.Gxx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

//访问者，访问
public class Painter {

    public void draw(Canvas canvas, int[][] mapInfo){
        System.out.println("绘制地图");
        MapBlockFactory mapBlockFactory = MapBlockFactory.getInstance();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int row = 0; row < Constant.blockNum; row++) {
            for (int col = 0; col <  Constant.blockNum; col++) {
                int t = mapInfo[row][col];
                MapBlock block = mapBlockFactory.getMapBlock(t);
                gc.drawImage(block.getImage(),row*Constant.blockSize,col*Constant.blockSize,Constant.blockSize,Constant.blockSize);
            }
        }
    }
}
