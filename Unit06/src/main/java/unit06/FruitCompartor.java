package unit06;

import java.util.Comparator;

public class FruitCompartor implements Comparator<Fruit>{

    @Override
    public int compare(Fruit a, Fruit b) {
        // double diff = a.getPrice() - b.getPrice();
        // if (diff < 0) {
        //     return -1;
        // } else if(diff > 0) {
        //     return 1;
        // } else {
        //     return 0;
        // }

        return Double.compare(a.getPrice(), b.getPrice());
    }
    
    
}
