package unit02.chickens;
// Dessa Shapiro

import java.util.Scanner;

// has the user input a number of chickens and prints out that number of random chickens as well as the egg they lay
public class ChickenFarm {
    public static void main(String[] args) {
        Scanner numOfChickens = new Scanner(System.in);
        System.out.println("Enter the number of chickens on the farm: ");
        Integer num = numOfChickens.nextInt();
        for(int i = 0; i<num; i++) {
            Chicken chicken = Chicken.randomChicken();
            Egg egg = new Egg(chicken.getColor(), chicken.getSize(), chicken.isCracked());
            System.out.println(chicken+", layed "+egg);


        }
        numOfChickens.close();

    }
}
