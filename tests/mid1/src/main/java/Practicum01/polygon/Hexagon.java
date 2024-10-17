package Practicum01.polygon;

public class Hexagon extends Polygon{
    public Hexagon(String name, int sideLength){
        super(name, 6, sideLength);
    }

    @Override
    public double area() {
        return 5*super.getSideLength()*super.getSideLength()/2.906;
    }

}

