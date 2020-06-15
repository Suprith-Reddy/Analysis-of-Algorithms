import java.util.*;

public class MST_DFS {
    public static void main(String[] args) {
        int n = 9;
        List<List<Integer>> adjList = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        List<Integer> a0 = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a4 = new ArrayList<>();
        List<Integer> a6 = new ArrayList<>();
        List<Integer> a8 = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();

        a0.add(1);
        a0.add(8);
        adjList.add(0,a0);

        a1.add(2);
        a1.add(4);
        adjList.add(1,a1);

        a2.add(3);
        adjList.add(2,a2);

        adjList.add(empty);

        a4.add(2);
        a4.add(6);
        adjList.add(4,a4);

        adjList.add(empty);

        a6.add(7);
        adjList.add(6,a6);

        adjList.add(empty);

        a8.add(2);
        adjList.add(8,a8);


        DFS(0, visited, adjList);
        
        /*Output:
        (0,1)
        (1,2)
        (2,3)
        (1,4)
        (4,6)
        (6,7)
        (0,8)
        */
    }
    private static void DFS(int node, boolean[] visited, List<List<Integer>> adjList){
        if(visited[node])
            return;
        visited[node] = true;

        for (Integer neighbor:
             adjList.get(node)) {
            if(!visited[neighbor])
                System.out.println("("+node+","+neighbor+")");
            DFS(neighbor, visited, adjList);
        }
    }
}
