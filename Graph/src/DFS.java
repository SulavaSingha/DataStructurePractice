import java.util.*;

public class DFS {
    Graph graph;
    boolean[] visited;
    Map<Integer, LinkedList<Integer>> edge;
    Stack<Integer> stack=new Stack<>();
    LinkedList<Integer> list;
    public DFS(Graph graph){
        this.graph=graph;
      visited =new boolean[graph.v.length];
        edge=graph.adj;
        list=new LinkedList<>();
    }
    public void dfsUtil(int vertex){
        list=edge.get(vertex);
        visited[vertex] =true;
        System.out.print(vertex + " ");
            if(list!=null){
    Iterator<Integer> i=list.iterator();
    while(i.hasNext()){
        int v=i.next();
        if(!visited[v]){
            dfsUtil(v);
                  }
    } }
}
    public Stack<Integer> dfsStronglyConnected(int vertex){
        visited[vertex]= true;
        list=edge.get(vertex);
        if(list!=null) {
            ListIterator<Integer> it= list.listIterator();
            while(it.hasNext()) {
                int i = it.next();
                if (!visited[i]) {
                    dfsStronglyConnected(i);
                }
                        }
            }
            stack.push(vertex);


        System.out.println(vertex);
        return stack;
    }
    public void dfsUtilScc(int vertex, boolean[] visited){
        list=edge.get(vertex);
        visited[vertex] =true;
        System.out.print(vertex + " ");
        if(list!=null){
            Iterator<Integer> i=list.iterator();
            while(i.hasNext()){
                int v=i.next();
                if(!visited[v]){
                    dfsUtilScc(v,visited);
                }
            } }
    }
}

