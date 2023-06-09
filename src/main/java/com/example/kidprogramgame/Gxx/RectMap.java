package com.example.kidprogramgame.Gxx;

import java.util.Random;

//第二个关卡用到的方形地图
public class RectMap extends GameMap{
    RectMap(){
        super();
        setMax_x(9);
        setMax_y(9);
        setMin_x(0);
        setMin_y(0);
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
        map[getMin_x()][getMax_y()] = 0;
        map[getMax_x()][getMin_y()] = 3;
    }

}
