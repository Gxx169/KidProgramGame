package com.example.kidprogramgame.Gxx;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Role extends ImageView{

    //乌龟位置这里的x,y是地图位置下标
    private int x,y;
    //开始位置
    private int s_x,s_y;

    Role(int x,int y){
        this.x = x;
        this.y = y;
        this.s_x = x;
        this.s_y = y;
        this.setTranslateX(s_x*Constant.blockSize);
        this.setTranslateY(s_y*Constant.blockSize);
        this.setImage(new Image(Constant.imagePath+"乌龟.png",Constant.blockSize,Constant.blockSize,true,true));
    }


    public void toUp() {
        int newX = (x)* Constant.blockSize;
        int newY = (--y)* Constant.blockSize;


        RotateTransition rotateTransition = new RotateTransition(Duration.millis(400),this);
        rotateTransition.setToAngle(0);


        goTo(newX,newY,rotateTransition);
    }


    public void toLeft() {
        int newX = (--x)* Constant.blockSize;
        int newY = (y)* Constant.blockSize;


        RotateTransition rotateTransition = new RotateTransition(Duration.millis(400),this);
        rotateTransition.setToAngle(-90);


        goTo(newX,newY,rotateTransition);
    }


    public void toRight() {
        int newX = (++x)* Constant.blockSize;
        int newY = (y)* Constant.blockSize;


        RotateTransition rotateTransition = new RotateTransition(Duration.millis(400),this);
        rotateTransition.setToAngle(90);


        goTo(newX,newY,rotateTransition);
    }


    public void toDown() {
        int newX = (x)* Constant.blockSize;
        int newY = (++y)* Constant.blockSize;


        RotateTransition rotateTransition = new RotateTransition(Duration.millis(400),this);
        rotateTransition.setToAngle(180);


        goTo(newX,newY,rotateTransition);
    }
    public void goTo(int x, int y,RotateTransition rotateTransition){
        // 创建TranslateTransition对象
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(500));
        transition.setToX(x);
        transition.setToY(y);
        //transition.play();
        SequentialTransition sequentialTransition = new SequentialTransition(rotateTransition,transition);
        sequentialTransition.play();
    }

    public int getMyX() {
        return x;
    }

    public int getMyY() {
        return y;
    }

    public void back(){
        this.x = s_x;
        this.y = s_y;
        this.setRotate(0);
        this.setTranslateX(s_x*Constant.blockSize);
        this.setTranslateY(s_y*Constant.blockSize);
    }
    public void show(){
        System.out.println(x+","+y);
    }
}
