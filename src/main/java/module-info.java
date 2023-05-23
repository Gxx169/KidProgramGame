module com.example.kidprogramgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.kidprogramgame to javafx.fxml;
    exports com.example.kidprogramgame;

    exports com.example.kidprogramgame.Gxx;
    opens com.example.kidprogramgame.Gxx to javafx.fxml;

    exports com.example.kidprogramgame.Hyb;
    opens com.example.kidprogramgame.Hyb to javafx.fxml;
}