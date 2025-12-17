module org.example.calculadora {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.calculadora.controller to javafx.fxml;
    exports org.example.calculadora.app;

}
