package com.example.kidprogramgame.Hyb;


import com.example.kidprogramgame.Gxx.FirstLevelBuilder;
import com.example.kidprogramgame.Gxx.Level;
import com.example.kidprogramgame.Gxx.TestMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


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

    private TestMap map;
    private ImageView turtle;
    Level level;

    public void initialize() {
        //使用TestMap
//        map = new TestMap();
//        turtle = map.getTurtle();
//        map.getStackPane()
        //使用Gxx
        FirstLevelBuilder firstLevelBuilder = new FirstLevelBuilder();
        level = firstLevelBuilder.getLevel();

        borderPane.setCenter(level.getMapPane());
    }
    public void up(){
       // map.moveTurtle(0, -1);
        level.toUp();
    }
    public void down() {
        //map.moveTurtle(0, 1);
        level.toDown();
    }
    public void left(){
        //map.moveTurtle(-1, 0);
        level.toLeft();
    }
    public void right(){
        //map.moveTurtle(1, 0);
        level.toRight();
    }
}