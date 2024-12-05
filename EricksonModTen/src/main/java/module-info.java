module com.example.ericksonmodten {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ericksonmodten to javafx.fxml;
    exports com.example.ericksonmodten;
}