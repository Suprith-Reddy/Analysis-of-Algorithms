package com.suprithgurudu;

import java.util.*;

public class FractionalKnapsack {
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm){
        //Creating list from elements of Hashmap
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

        //Sorting the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //Asc Sort -- need to swap o1 & o2
                Integer r = (o2.getValue()).compareTo(o1.getValue()); //Desc Sort
                return r != 0 ? r: 1;
            }
        });

        //putting data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for(Map.Entry<Integer,Integer> aa: list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static int fracKnap(int[] W, int[] V, int cap){
        int res = 0;

        HashMap<Integer, Integer> ratio_map = new HashMap<>();

        for(int i=0; i<W.length; i++){
            ratio_map.put(i,V[i]/W[i]);
        }

        HashMap<Integer, Integer> ratio_sorted = sortByValue(ratio_map);

        for(Map.Entry<Integer, Integer> entry: ratio_sorted.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(cap > W[key]){
                res += W[key]*value;
                cap -= W[key];
            }
            else{
                res += cap*value;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] weight = {40, 10, 20, 24};
        int[] value = {280, 100, 120, 120};
        int capacity = 60;

        int res = fracKnap(weight, value, capacity);
        System.out.println(res);
    }
}
