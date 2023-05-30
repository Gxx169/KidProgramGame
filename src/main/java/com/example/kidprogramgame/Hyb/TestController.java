package com.example.kidprogramgame.Hyb;


import com.example.kidprogramgame.Gxx.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TestController {

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
        LevelBuilder levelBuilder = new FirstLevelBuilder();
        //获取关卡
        level = levelBuilder.getLevel();
        //将关卡加入游戏主体中
        borderPane.setCenter(level.getLevelPane());

    }

    //随机生成模拟指令数组，测试执行指令数组方法
    public void useExecuteCommandTest() {
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

    //执行命令数组
    public void executeCommand(List<Integer> m) {
        //避免阻塞ui线程
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        switch (s){
            case 0:
                System.out.println(s);
                break;
            case 1:
                System.out.println(s);
                alert.setTitle("游戏失败！");
                alert.setContentText("乌龟掉进陷阱了!");
                alert.showAndWait();
                break;
            case -1:
                System.out.println(s);
                alert.setTitle("游戏失败！");
                alert.setContentText("乌龟迷路了!");
                alert.showAndWait();
                restart();
                break;
            case 2:
                System.out.println(s);
                alert.setTitle("游戏失败！");
                alert.setContentText("乌龟掉进河里了!");
                alert.showAndWait();
                restart();
                break;
            case 3:
                System.out.println(s);
                stage.getIcons().add(new Image(Constant.imagePath+"成功.png"));
                alert.setTitle("游戏成功！");
                alert.setContentText("乌龟到家了!,得分："+level.getScores());
                alert.showAndWait();
                restart();
                break;
        }
        System.out.println("检测状态");
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