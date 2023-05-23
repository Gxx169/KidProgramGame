package com.example.kidprogramgame.Gxx;

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
                int p = Math.round(10);
                if(p==6){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = 1;
                }
            }
        }
    }
}
