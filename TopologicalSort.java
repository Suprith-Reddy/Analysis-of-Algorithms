package com.suprithgurudu;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Graph creation:
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);
        List<Integer> c = new ArrayList<>();
        c.add(4);
        List<Integer> d = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        e.add(3);
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);

        int n = graph.size();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            DFS(graph, i, visited, result);
        }
        for(Integer item : result){
            System.out.println(item);
        }
    }
    private static void DFS(List<List<Integer>> graph, int i, boolean[] visited, List<Integer> result){
        if(!visited[i]){
            visited[i] = true;
            for(Integer nbr : graph.get(i)){
                DFS(graph, nbr, visited, result);
            }
            result.add(0, i);
        }
    }
}
