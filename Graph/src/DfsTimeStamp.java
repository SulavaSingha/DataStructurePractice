import java.util.LinkedList;
enum Color{
    white,grey,black;
}
public class DfsTimeStamp {
    Graph g;
    int ts=0;
    int flag=0;
    int[] arr;
    int[] dep;
    boolean [] visited;
    LinkedList<Color> color;
    LinkedList<Integer> list= new LinkedList<>();
    int source;
    public DfsTimeStamp(Graph g, int source){
     this.g=g;
     this.source=source;
         arr= new int[g.v.length];
        dep=new int[g.v.length];
        visited=new boolean[g.v.length];
        color=new LinkedList<>();
    }
    public boolean Dfs(int v,int t){
       visited[v]=true;
       ts++;
       arr[v]=ts;
       list=g.adj.get(v);
       list.stream().forEach(i-> {
           if (!visited[i]) {
               Dfs(i, ts);
           }
               }

       );
        ts++;
        if(dep[v]==0)
            flag=1;
        dep[v] = ts;
        System.out.println(dep[v]);
       if(flag==1){
           return true;
       }
return false;
    }
}
