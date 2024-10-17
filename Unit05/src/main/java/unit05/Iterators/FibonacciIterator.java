// Dessa Shapiro
package unit05.Iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class FibonacciIterator implements Iterator<Long> {
        private int index;
        private ArrayList<Long> arrayList;
        
        /**
         * 
         * @param arrayList
         */
        public FibonacciIterator (ArrayList<Long> arrayList) {
            this.arrayList = arrayList;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.arrayList.size();
        }

        @Override
        public Long next() {
            int currIndex = this.index;
            this.index ++;
            return arrayList.get(currIndex);
        } 
        
}
