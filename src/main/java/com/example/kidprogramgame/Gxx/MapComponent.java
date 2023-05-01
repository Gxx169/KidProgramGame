package com.example.kidprogramgame.Gxx;

import javafx.scene.image.Image;

public class MapComponent {
    // 长度和宽度
    private int height;
    private int width;
    // 图片
    private Image image;

    public MapComponent(String image, int height, int width){
        Image img = new Image(image, width, height, true, true);
        this.image = img;
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Image getImage() {
        return image;
    }
}
