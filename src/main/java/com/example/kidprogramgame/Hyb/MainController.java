package com.example.kidprogramgame.Hyb;


import com.example.kidprogramgame.Gxx.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainController {

    @FXML
    BorderPane borderPane;
    @FXML
    Button upButton ;
    @FXML
    Button downButton;
    @FXML
    Button leftButton ;
    @FXML
    Button rightButton;


    //依赖倒转原则，依赖游戏关卡部分提供的接口，通过该接口来操控游戏地图中角色，获取当前游戏状态
    Action level;

    public void initialize() {

        //实例化关卡建造者
        LevelBuilder levelBuilder = new SecondLevelBuilder();
        //获取关卡
        level = levelBuilder.getLevel();
        //将关卡加入游戏主体中
        borderPane.setCenter(level.getLevelPane());

    }

    //执行命令数组
    public void executeCommand(List<Integer> m) throws InterruptedException {
        Thread thread = new Thread(()->{
            for(int i = 0;i< m.size();i++){
                switch (m.get(i)){
                    case 0:
                        up();
                        break;
                    case 1:
                        right();
                        break;
                    case 2:
                        down();
                        break;
                    case 3:
                        left();
                        break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(level.getSate()!=0){
                    break;
                }
            }
        });

        thread.start();
    }
    //重新开始
    public void restart(){
        level.reStart();
    }
    //通过获取的状态来决定游戏结果
    public void check(int s){
        Alert alert;
        switch (s){
            case 0:
                System.out.println(s);
                break;
            case 1:
                System.out.println(s);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("游戏失败！");
                alert.setHeaderText(null);
                alert.setContentText("乌龟掉进陷阱了!");
                alert.showAndWait();
                break;
            case -1:
                System.out.println(s);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("游戏失败！");
                alert.setHeaderText(null);
                alert.setContentText("乌龟迷路了!");
                alert.showAndWait();
                restart();
                break;
            case 2:
                System.out.println(s);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("游戏失败！");
                alert.setHeaderText(null);
                alert.setContentText("乌龟掉进河里了!");
                alert.showAndWait();
                restart();
                break;
            case 3:
                System.out.println(s);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("游戏成功！");
                alert.setHeaderText(null);
                alert.setContentText("乌龟到家了!");
                alert.showAndWait();
                restart();
                break;

        }
        System.out.println("检测状态");
    }

    public void useExecuteCommandTest() throws InterruptedException {
        List<Integer> list = new ArrayList();
        int size = 10;
        Random random = new Random();
        int p;
        while (size-->0){
            //模拟命令 上下左右
            p = random.nextInt(3);
            list.add(p);
        }
        executeCommand(list);
    }

    public void up(){
        Platform.runLater(()->{
            level.toUp();
            check(level.getSate());
        });
    }

    public void down() {
        Platform.runLater(()->{
            level.toDown();
            check(level.getSate());
        });

    }

    public void left(){
        Platform.runLater(()->{
            level.toLeft();
            check(level.getSate());
        });

    }

    public void right(){
        Platform.runLater(()->{
            level.toRight();
            check(level.getSate());
        });

    }
}