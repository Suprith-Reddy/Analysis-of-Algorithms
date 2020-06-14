import java.util.*;

/* THIS DOESN'T WORK ON LEETCODE THOUGH, STRANGE!!!!! */

public class HashMapSortByValue {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>();

        hashMap.put("a", 10);
        hashMap.put("b", 30);
        hashMap.put("c", 20);
        hashMap.put("d", 5);
        hashMap.put("e", 40);

        //Creates list of HashMap entries through ArrayList class constructor call
        //hashMap.entrySet() returns a set of key, value pairs unordered
        List<HashMap.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());

        //Overriding compare method of Comparator class
        Comparator<HashMap.Entry<String, Integer>> myComparator = new Comparator<>() {
            @Override
            public int compare(HashMap.Entry<String, Integer> o1,
                               HashMap.Entry<String, Integer> o2) {
                Integer v1 = o1.getValue();
                Integer v2 = o2.getValue();

                return v1.compareTo(v2);
            }
        };

        //In place of Collections.sort() -> list.sort()
        list.sort(myComparator);

        //Put all sorted entries of a list to linkedHashMap
        //because there's no ordering in a HashMap we need some
        //chaining technique -> LinkedList of HashMap entries
        for (HashMap.Entry<String, Integer> entry:
             list) {
            linkedMap.put(entry.getKey(), entry.getValue());
        }

        for (HashMap.Entry<String, Integer> entry:
             linkedMap.entrySet()) {
            System.out.println("Key:"+entry.getKey()+" Value:"+entry.getValue());
        }
    }
}
