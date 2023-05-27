package com.example.kidprogramgame.Gxx;

import javafx.scene.image.Image;

//地图快
public class MapBlock {
    private int height;
    private int width;
    private Image image;

    MapBlock(String image){
        this.height = Constant.blockSize;
        this.width = Constant.blockSize;
        this.image = new Image(image,width,height,true,true);
    }

    public Image getImage() {
        return image;
    }

}
