package com.example.kidprogramgame.Gxx;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Role extends ImageView implements Action{
    //这里的x,y是地图位置下标
    private int x;
    private int y;

    Role(){
        this.setImage(new Image(Constant.imagePath+"乌龟.png",Constant.blockSize,Constant.blockSize,true,true));
    }

    @Override
    public void toUp() {
        int newX = (x)* Constant.blockSize;
        int newY = (--y)* Constant.blockSize;
        goTo(newX,newY);
    }

    @Override
    public void toLeft() {
        int newX = (--x)* Constant.blockSize;
        int newY = (y)* Constant.blockSize;
        goTo(newX,newY);
    }

    @Override
    public void toRight() {
        int newX = (++x)* Constant.blockSize;
        int newY = (y)* Constant.blockSize;
        goTo(newX,newY);
    }

    @Override
    public void toDown() {
        int newX = (x)* Constant.blockSize;
        int newY = (++y)* Constant.blockSize;
        goTo(newX,newY);

    }
    public void goTo(int x, int y){
        // 创建TranslateTransition对象
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(500));
        transition.setToX(x);
        transition.setToY(y);
        transition.play();
    }

    public int getMyX() {
        return x;
    }

    public int getMyY() {
        return y;
    }
}
