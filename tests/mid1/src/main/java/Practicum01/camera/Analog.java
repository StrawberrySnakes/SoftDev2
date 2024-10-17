package Practicum01.camera;

public class Analog extends Camera {

    private int picturesRemaining;

    public Analog(String manufacturer, String model, LensType lensType, int picturesRemaining) {
        super(manufacturer, model, lensType);
        this.picturesRemaining = picturesRemaining;
    }

    public void setPicturesRemaining(int num) {
        this.picturesRemaining = num;
    }

    public void loadFilmRoll(int size) {
        setPicturesRemaining(size);
    }

    @Override
    public boolean takePicture() {
        return this.picturesRemaining > 0;
    }


    
}
