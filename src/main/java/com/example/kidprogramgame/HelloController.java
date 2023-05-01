package com.example.kidprogramgame;

import com.example.kidprogramgame.Gxx.GameMap;
import com.example.kidprogramgame.Gxx.OneMap;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;



public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Pane pane;
    private Canvas canvas;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        GameMap mapGanvas = new OneMap();
        canvas = mapGanvas.getMapCanvas();

        pane.getChildren().add(canvas);
    }
}