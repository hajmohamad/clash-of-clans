module com.example.clash {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.clash to javafx.fxml;
    exports com.example.clash;
}