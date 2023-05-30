package com.example.kidprogramgame.Gxx;

import java.util.Random;

public class BridgeMap extends GameMap{

    public BridgeMap(){
        super();
        setMin_x(3);
        setMax_x(5);
        setMin_y(0);
        setMax_y(9);
        initMapInform();
    }
    //初始化地图信息
    @Override
    public void initMapInform() {
        int[][] map = getMapInform();
        for(int i = 0; i<Constant.blockNum; i++){
            for(int j = 0; j<Constant.blockNum; j++){
                if(i<getMin_x()||i>getMax_x()){
                    map[i][j] = 2;
                }
                else{
                    Random random = new Random();
                    int p = random.nextInt(9);
                    if(p==4){
                        map[i][j] = 1;
                    } else if (p == 6) {
                        map[i][j] = 4;
                    } else{
                        map[i][j] = 0;
                    }
                }

            }
        }
        map[getMin_x()][getMax_y()] = 0;
        map[getMax_x()][getMin_y()] = 3;
    }
}
