package com.example.kidprogramgame.Gxx;

import java.util.Random;

public class RectMap extends GameMap{

    RectMap(){
        super();
        initMapInform();
    }

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
}
