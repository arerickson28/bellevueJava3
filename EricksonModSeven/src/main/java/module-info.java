module com.example.ericksonmodseven {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ericksonmodseven to javafx.fxml;
    exports com.example.ericksonmodseven;
}