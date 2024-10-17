package practicum2.thermostat.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import practicum2.thermostat.model.Thermostat;

public class ThermostatEventHandlerIncrease implements EventHandler<ActionEvent> {

    private Thermostat thermostat;
    private Label tempLabel;
    private Label heatStat;

    public ThermostatEventHandlerIncrease(Thermostat thermostat, Label tempLabel) {
        this.thermostat = thermostat;
        this.tempLabel = tempLabel;
    }

    @Override
    public void handle(ActionEvent event) {
        thermostat.increaseTemperature();
        // if (thermostat.isHeatOn()) {
        //     heatStat.
        // }
    }
    
}
