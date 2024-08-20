module com.example.circuitdesigner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
    opens com.example.circuitdesigner to javafx.fxml, com.fasterxml.jackson.databind;

    exports com.example.circuitdesigner;
}