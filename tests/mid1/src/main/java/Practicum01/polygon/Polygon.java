package Practicum01.polygon;

public abstract class Polygon {
    protected static String name;
    protected static int numSides;
    protected static int sideLength;

    public Polygon(String name, int numSides, int sideLength) {
        Polygon.name = name;
        Polygon.numSides = numSides;
        Polygon.sideLength = sideLength;
    }


    public String getName() {return Polygon.name;}

    public int getNumSides() {return Polygon.numSides;}

    public int getSideLength() {return Polygon.sideLength;}

    public double perimiter() {
        return Polygon.numSides * Polygon.sideLength;
    };

    public abstract double area();

    @Override
    public String toString() {return Polygon.name+": Sides"+Polygon.numSides+" Side Length: "+ Polygon.sideLength;}






} 
