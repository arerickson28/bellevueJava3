module com.example.scratch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scratch to javafx.fxml;
    exports com.example.scratch;
}