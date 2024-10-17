// Dessa Shapiro
package unit06.Sushi;

import java.util.Random;

public class Sushi implements Comparable <Sushi>{
private final double weight;
private final double cost;
private final int num;

/**
 * 
 * @param num
 */
public Sushi(int num) {
	Random random = new Random();
    this.num = num;
    this.weight = random.nextInt(80) + 20;
    this.cost = random.nextInt(30) + 10;
}

public double getCost() {return this.cost;}

@Override
/**
 * 
 * @param o
 * @return
 */
public int compareTo(Sushi o) {
	return Double.compare(this.weight,o.weight);
}

@Override
public String toString() {
    return String.format("Sushi{number-ID, weight-Id grams, $Id}",this.num, this.weight, this.cost);
    
}

}

