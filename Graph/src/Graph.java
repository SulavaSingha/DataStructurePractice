import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

    int[] v=new int[5];
    Map<Integer, LinkedList<Integer>> adj =new HashMap<>();

    public Graph(int[] v){
        this.v=v;
            }
            public Graph(){

            }
         public void addEdge(int v, int w){
        LinkedList<Integer> list;
        if(adj.containsKey(v)){
           list=adj.get(v);
           list.add(w);
        }
        else {
            list=new LinkedList<>();
            list.add(w);
            adj.put(v,list);
        }
    }
         public static void main(String[] args){
           int[] v= {0,1,2,3,4};
           Graph graph=new Graph(v);
           graph.addEdge(v[0],v[1]);
           graph.addEdge(v[0],v[2]);
           graph.addEdge(v[1],v[2]);
           graph.addEdge(v[2],v[0]);
           graph.addEdge(v[2],v[3]);
           graph.addEdge(v[3],v[3]);
           graph.addEdge(v[3],v[4]);
           graph.addEdge(v[4],v[1]);
           DFS dfs=new DFS(graph);
           System.out.println("_______________DFS_____________________");
           dfs.dfsUtil(v[0]);
           BFS bfs=new BFS(graph);
             System.out.println("_______________BFS_____________________");
           bfs.bfsUtil(v[0]);
           DfsTimeStamp dts=new DfsTimeStamp(graph,v[0]);
           boolean isCyclic =dts.Dfs(v[0],0);
           System.out.println("Is Acyclic" +isCyclic);
           Transpose t= new Transpose(graph);
           Graph gt= t.getTranspose();
           System.out.println("-------------The Graph ---------------");
           graph.adj.entrySet().stream().forEach(e->{
               System.out.println("vertex :" + e.getKey());
               System.out.println("The edges: ");
               e.getValue().stream().forEach(i -> {
                   System.out.println(i +" ,");
               });
           });
             System.out.println("-------------The Transpose Graph ---------------");
             gt.adj.entrySet().stream().forEach(e->{
                 System.out.println("vertex :" + e.getKey());
                 System.out.println("The edges: ");
                 e.getValue().stream().forEach(i -> {
                     System.out.println(i);
                 });
             });
             int []a = {0,1,2,3,4};
             Graph g = new Graph(a);
             g.addEdge(1, 0);
             g.addEdge(0, 2);
             g.addEdge(2, 1);
             g.addEdge(0, 3);
             g.addEdge(3, 4);
             Scc scc= new Scc(g);
             scc.getSCC();

         }
}
