// Dessa Shapiro
package unit05.Iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class IterableFibonacci implements Iterable<Long>{
    private ArrayList<Long> arrayList;
        
    /**
     * 
     * @param a
     * @param b
     */
        public IterableFibonacci(long a, long b) {
            arrayList = new ArrayList<>();
            arrayList.add(a);
            arrayList.add(b);
        } 
        
        public void add(){
            int size= length();
            long a = arrayList.get(size-2);
            long b = arrayList.get(size-1);
            arrayList.add(a+b);
        }
        
        /**
         * 
         * @param index
         * @return
         */
        public long get(int index){
                return arrayList.get(index);
            
        }

        /**
         * 
         * @return
         */
        public int length(){
                return arrayList.size();
        }
        
        @Override
        public Iterator<Long> iterator(){
                return new FibonacciIterator(arrayList);
        }
        
    
}
