package unit06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetsAndMaps {

    public static void addAndPrint(Set<String> set) {
        set.add("a");
        set.add("Za");
        set.add("M");
        set.add("zb");
        set.add("s");
        for (String value : set) {
            System.out.println(value);
        }
    }

    public static void putAndPrint(Map<String, Integer> map){
        map.put("a", 1);
        map.put("Za", 2);
        map.put("M", 3);
        map.put("zb", 4);
        map.put("s", 5);
        for(String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
    public static void main(String[] args) {
        System.out.println("Hash Set:");
        addAndPrint(new HashSet<>());
        System.out.println("Tree Set:");
        addAndPrint(new TreeSet<>());
        System.out.println("Tree Set using comparator");
        addAndPrint(new TreeSet<>(new AlphabeticComparator()));

        System.out.println("Hash Map");
        putAndPrint(new HashMap<>());
        System.out.println("Tree Map");
        putAndPrint(new TreeMap<>(new AlphabeticComparator()));

    }
}
