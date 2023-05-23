package com.example.kidprogramgame.Hyb;


import com.example.kidprogramgame.Gxx.TestMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public class MainController {
    public Pane mapContainer;
    @FXML
    private Label welcomeText;
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

    private TestMap map;
    private ImageView turtle;

    public void initialize() {
        map = new TestMap();
        turtle = map.getTurtle();
        borderPane.setCenter(map.getStackPane());
    }
    public void up(){
        map.moveTurtle(0, -1);
    }
    public void down() {
        map.moveTurtle(0, 1);
    }
    public void left(){
        map.moveTurtle(-1, 0);
    }
    public void right(){
        map.moveTurtle(1, 0);
    }
}