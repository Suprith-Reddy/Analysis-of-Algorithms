import java.util.*;
import java.util.Queue;

class GraphNode{
    int data;
    List<GraphNode> adj;
    boolean visited = false;
    public GraphNode(int data){
        this.data = data;
        this.adj = new ArrayList<>();
    }
}
public class BreadthFirstSearch {
    public static void main(String[] args) {
        //INIT GRAPH
        List<GraphNode> gn = new ArrayList<>();
        //Node creation
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        GraphNode five = new GraphNode(5);
        GraphNode six = new GraphNode(6);
        GraphNode seven = new GraphNode(7);
        //Adjacency lists
        one.adj.add(two);
        one.adj.add(four);
        two.adj.add(three);
        four.adj.add(three);
        four.adj.add(five);
        five.adj.add(six);
        six.adj.add(seven);
        seven.adj.add(three);
        //Add nodes to graph list
        gn.add(one);
        gn.add(two);
        gn.add(three);
        gn.add(four);
        gn.add(five);
        gn.add(six);
        gn.add(seven);


        System.out.println(breadthFirstSearch(gn,four,three)); //returns true if success
    }

    private static boolean breadthFirstSearch(List<GraphNode> gn, GraphNode s, GraphNode t) {
        Queue<GraphNode> q = new LinkedList<>();
        q.add(s);
        s.visited = true;

        while(!q.isEmpty()){
            for (GraphNode n:
                 q.peek().adj) {
                if(n.data == t.data)
                    return true;
                else if(!n.visited) {
                    q.add(n);
                    n.visited = true;
                }
            }
            q.poll();
        }

        return false;
    }

}
