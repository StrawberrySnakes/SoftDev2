package practicum2.thermostat.model;

public class Thermostat {
    private static final int HEAT_ON_TEMP = 65;
    private static final int AC_ON_TEMP = 78;
    private static final int INITIAL_TEMP = 70;
    private ThermostatObserver observer;
    private int currentTemp;


    public Thermostat() {
        currentTemp = INITIAL_TEMP; 
    }

    private void notifyObserver() {
        if (observer != null) {
            observer.temperatureChanged(this);
        }
    }

    public int getCurrentTemperature() { return currentTemp; }

    public void increaseTemperature() {
        currentTemp++;
        notifyObserver();
        
    }

    public void decreaseTemperature() {
        currentTemp--;
        notifyObserver();
    }

    public boolean isHeatOn() {
        return currentTemp <= HEAT_ON_TEMP;
    }

    public boolean isACOn() {
        return currentTemp >= AC_ON_TEMP;
    }
}
