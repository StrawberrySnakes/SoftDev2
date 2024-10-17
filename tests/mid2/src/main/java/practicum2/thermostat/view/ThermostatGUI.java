package practicum2.thermostat.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox; 
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import practicum2.thermostat.model.Thermostat;

public class ThermostatGUI extends Application {
    private static final Font TEMPERATURE_FONT = new Font("Courier New", 48);
    private static final Font TEMPERATURE_CONTROL_FONT = new Font("Courier New", 32);
    private static final Font STATUS_FONT = new Font("Roboto", 12);

    private static final Background TEMPERATURE_BACKGROUND = new Background(
        new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)
    );

    private Thermostat thermostat;
    private Label temperature;
    private Label heatStatus;
    private Label acStatus;

    private Button makeTemperatureControlButton(String text) {
        Button button = new Button(text);
        button.setFont(TEMPERATURE_CONTROL_FONT);
        button.setAlignment(Pos.CENTER);
        button.setPadding(new Insets(10));
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        HBox.setHgrow(button, Priority.ALWAYS);
        return button;
    }

    private Label makeStatusLabel(String text,Color textColor) {
        Label label = new Label(text);
        label.setTextFill(textColor);
        label.setFont(STATUS_FONT);
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10));
        HBox.setHgrow(label,Priority.ALWAYS);
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Thermostat");

        thermostat = new Thermostat();

        // Create and initialize the temperature label
        temperature = new Label(Integer.toString(thermostat.getCurrentTemperature()));
        temperature.setBackground(TEMPERATURE_BACKGROUND);
        temperature.setTextFill(Color.WHITE);
        temperature.setAlignment(Pos.CENTER);
        temperature.setFont(TEMPERATURE_FONT);
        temperature.setPadding(new Insets(20));
        temperature.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        // Create and initialize the temperature increase and decrease buttons
        Button increaseTemp = makeTemperatureControlButton("+");
        increaseTemp.setOnAction(new ThermostatEventHandlerIncrease(thermostat, temperature));

        Button decreaseTemp = makeTemperatureControlButton("-");
        decreaseTemp.setOnAction(new ThermostatEventHandlerDecrease(thermostat, temperature));

        HBox temperatureControls = new HBox(decreaseTemp, increaseTemp);

        // Create and initialize the Heat and AC status labels
        String statusText = "Heat: ";
        if (thermostat.isHeatOn()) {
            statusText += "On";
        } else {
            statusText += "Off";
        }
        heatStatus = makeStatusLabel(statusText,Color.RED);

        statusText = "AC: ";
        if (thermostat.isHeatOn()) {
            statusText += "On";
        } else {
            statusText += "Off";
        }
        acStatus = makeStatusLabel(statusText,Color.BLUE);

        HBox statusBox = new HBox(heatStatus,acStatus);

        VBox mainBox = new VBox(temperature,temperatureControls,statusBox);

        Scene scene = new Scene(mainBox);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

    
}
