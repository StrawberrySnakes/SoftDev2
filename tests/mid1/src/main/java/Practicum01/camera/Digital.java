package Practicum01.camera;

public class Digital extends Camera{
    
    private int pictureSize;
    private int bytes;

    public Digital(String manufacturer, String model, LensType lensType, int pictureSize, int bytes) {
        super(manufacturer, model, lensType);
        this.pictureSize = pictureSize;
        this.bytes = bytes;
    }

    public void setbytes(int size) {
        this.bytes = size;
    }

    public void insertMemoryCard(int size) {
        setbytes(size);
    }

    @Override
    public boolean takePicture() {
        if(this.pictureSize <= this.bytes) {
            return true;
        } else {
            return false;
        }

    }
 
}
