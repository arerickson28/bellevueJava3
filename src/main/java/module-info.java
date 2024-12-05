module com.example.bellevuejava3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bellevuejava3 to javafx.fxml;
    exports com.example.bellevuejava3;
}