class GraphList{
    List<Integer> adj;
    public GraphList(){
        this.adj = new ArrayList<>();
    }
}
public class EdgeListToAdjList {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5; //# of nodes
        
        GraphList[] gl = new GraphList[n];
        for(int i=0;i<n;i++){
            gl[i] = new GraphList();
        }

        for(int i=0;i<edges.length;i++){
            gl[edges[i][0]].adj.add(edges[i][1]); //Only if Directed Graph is given
            gl[edges[i][1]].adj.add(edges[i][0]); //Need both instructions if Undirected is given
        }

        for (GraphList g:
             gl) {
            for (Integer n:
                 g.adj) {
                System.out.print(n);
            }
            System.out.println();
        }
    }
}
