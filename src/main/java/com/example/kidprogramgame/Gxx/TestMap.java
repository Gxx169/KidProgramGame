package com.example.kidprogramgame.Gxx;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class TestMap {
    private int tileSize = 64; // 地图格子大小
    private int numRows = 10; // 地图行数
    private int numCols = 10; // 地图列数
    private int x = 0; // 人物初始位置X坐标
    private int y = 0; // 人物初始位置Y坐标

    private int[][] map = {   // 地图数据，0表示空地，1表示陷阱
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private Pane stackPane;

    private ImageView turtle; // 乌龟图像

    public TestMap(){
        Canvas canvas = new Canvas(640, 640);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (map[row][col] == 1) {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                } else {
                    gc.setFill(Color.RED);
                    gc.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                }
            }
        }
        // 创建乌龟
        Image turtleImage = new Image("file:src/main/resources/com/example/kidprogramgame/image/乌龟.png",64,64,true,true);
        turtle = new ImageView(turtleImage);
        turtle.setLayoutX(x);
        turtle.setLayoutY(y);
        System.out.println("layoutX: "+turtle.getLayoutX()+",X:"+turtle.getX());
        System.out.println("layoutY: "+turtle.getLayoutY()+",Y:"+turtle.getY());
        stackPane = new Pane(canvas, turtle);
        stackPane.setPrefSize(640,640);
    }

    public void moveTurtle(int dx, int dy) {
        System.out.println("turtle.getLayoutX(): "+turtle.getLayoutX()+",turtle.getX():"+turtle.getX()+"x:"+x);

        int newCol = (int) ((x + dx * tileSize) / tileSize);
        int newRow = (int) ((y + dy * tileSize) / tileSize);


        int newX = x + dx * tileSize;
        int newY = y + dy * tileSize;

        System.out.println("新位置: "+newX+","+newY);

        if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
            if (map[newRow][newCol] == 1) {
                // 乌龟掉进了陷阱
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText(null);
                alert.setContentText("You lose!");
                alert.showAndWait();


                reStart();
            } else {

                // 创建TranslateTransition对象
                TranslateTransition transition = new TranslateTransition();
                transition.setNode(turtle);
                transition.setDuration(Duration.millis(500));

                transition.setToX(newX);
                transition.setToY(newY);

                //动画播放完毕后移动乌龟
                transition.setOnFinished(event -> {
                    System.out.println("turtle.getLayoutX(): "+turtle.getLayoutX()+",turtle.getX():"+turtle.getX()+"x:"+x);
                });
                transition.play();
                x = newX;
                y = newY;
            }
        }
    }

    public Pane getStackPane() {
        return stackPane;
    }

    public ImageView getTurtle() {
        return turtle;
    }

    void reStart(){
        turtle.setTranslateX(0);
        turtle.setTranslateY(0);
        x = 0;
        y = 0;
    }
}
