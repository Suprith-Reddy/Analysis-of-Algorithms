package com.suprithgurudu;

import java.util.ArrayList;
import java.util.List;
class Edge{
    private int to;
    private int weight;
    Edge(){ }
    Edge(int _to, int _weight){
        to = _to;
        weight = _weight;
    }
    public int get_to(){
        return to;
    }
    public int get_weight(){
        return weight;
    }
    public void set_to(int _to){
        to = _to;
    }
    public void set_weight(int _weight){
        weight = _weight;
    }
}
public class SingleSrcShortPath {
    public static void main(String[] args) {
        List<List<Edge>> graph = new ArrayList<>();

        // Graph creation:
        List<Edge> a = new ArrayList<>();
        Edge edge_1 = new Edge(1,4);
        a.add(edge_1);
        List<Edge> b = new ArrayList<>();
        Edge edge_2 = new Edge(4, 2);
        Edge edge_3 = new Edge(2, -1);
        b.add(edge_2);
        b.add(edge_3);
        List<Edge> c = new ArrayList<>();
        Edge edge_4 = new Edge(4, 2);
        c.add(edge_4);
        List<Edge> d = new ArrayList<>();
        List<Edge> e = new ArrayList<>();
        Edge edge_5 = new Edge(3, 6);
        e.add(edge_5);
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);

        int n = graph.size();
        List<Integer> topOrder = topSort(graph, n);
        Integer[] dist = new Integer[n];
        int start = 1;
        dist[start] = 0;

        for(Integer i : topOrder){
            if(dist[i] != null){
                for(Edge edge : graph.get(i)){
                    int newDist = dist[i] + edge.get_weight();
                    if(dist[edge.get_to()] == null) dist[edge.get_to()] = newDist;
                    else dist[edge.get_to()] = Math.min(newDist, dist[edge.get_to()]);
                    // Longest path -> change min to max above
                }
            }
        }

        for(Integer dst : dist){
            System.out.println(dst);
        }
    }
    private static List<Integer> topSort(List<List<Edge>> graph, int n){
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            DFS(graph, i, visited, result);
        }
        return result;
    }
    private static void DFS(List<List<Edge>> graph, int i, boolean[] visited, List<Integer> result){
        if(!visited[i]){
            visited[i] = true;
            for(Edge nbr : graph.get(i)){
                DFS(graph, nbr.get_to(), visited, result);
            }
            result.add(0, i);
        }
    }
}
