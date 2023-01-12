module com.example.worddictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.worddictionary to javafx.fxml;
    exports com.example.worddictionary;
}