module com.example.local2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.example.local2 to javafx.fxml;
    exports com.example.local2;
}