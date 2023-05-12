module com.example.contactappmodification {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactappmodification to javafx.fxml;
    exports com.example.contactappmodification;
}