package Practicum01.polygon;

public class Pentagon extends Polygon {
    
    public Pentagon(String name, int sideLength){
        super(name, 5, sideLength);
    }

    @Override
    public double area() {
        return 5*super.getSideLength()*super.getSideLength()/2.906;
    }

}
