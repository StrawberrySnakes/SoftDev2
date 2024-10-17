package Practicum01.camera;

public abstract class Camera {
    protected static String manufacturer;
    protected static String model;
    protected static LensType lensType;

    public Camera(String manufacturer, String model, LensType lensType) {
        Camera.manufacturer = manufacturer;
        Camera.model = model;
        Camera.lensType = lensType;
    }

    public abstract boolean takePicture();

    


}
