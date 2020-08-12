import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
    Map<Integer, LinkedList<Edge>> adj = new HashMap<>();

    public Graph() {

    }

    public void addEdge(int v, Edge e) {
        LinkedList<Edge> list;
        if (adj.containsKey(v)) {
            list = adj.get(v);
            list.add(e);
        } else {
            list = new LinkedList<>();
            list.add(e);
            adj.put(v, list);
        }
    }
    public static void main(String [] args){
        Graph g= new Graph();
        int[] w= {4,5,10,8,7,30};
        int[] v={0,1,2,3,4,5};
        for(int i=0;i<5;i++){
            g.addEdge(v[i],new Edge(v[i+1],w[i]));
        }
        g.addEdge(v[5],new Edge(v[0],w[5]));
        System.out.println("The union algorithm");
       // UnionGraph u= new UnionGraph(g);
        //u.findUnion();
        KruskalAlgo k= new KruskalAlgo(g);
        k.mSTAlgo();
    }
}
