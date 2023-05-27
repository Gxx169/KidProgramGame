package com.example.kidprogramgame.Gxx;

import java.util.Random;

//第二个关卡用到的方形地图
public class RectMap extends GameMap{

    RectMap(){
        super();
        initMapInform();
    }

    //初始化地图信息
    @Override
    public void initMapInform() {
        int[][] map = getMapInform();
        for(int i = 0; i<Constant.blockNum; i++){
            for(int j = 0; j<Constant.blockNum; j++){
                Random random = new Random();
                int p = random.nextInt(9);
                if(p==4){
                    map[i][j] = 1;
                }
                else{
                    map[i][j] = 0;
                }
            }
        }
    }

    //接受访问者，画家
    @Override
    void drawMap(Painter painter) {
        //画家访问游戏地图的画布和地图信息，在画布上根据地图信息进行绘制
        painter.draw(getMapCanvas(),getMapInform());
    }
}
