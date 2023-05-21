module com.javarush.cryptanalyzer.popov.cryptanalyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.javarush.cryptanalyzer.popov.cryptanalyzer to javafx.fxml;
    exports com.javarush.cryptanalyzer.popov.cryptanalyzer;
}