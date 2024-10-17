module practicum2 {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;

    opens practicum2.thermostat.view to javafx.fxml;
    exports practicum2.thermostat.model;
    exports practicum2.thermostat.view;
    exports practicum2.bstminmax;
    exports practicum2.solarsystem;
    exports practicum2.reverselist;
}
