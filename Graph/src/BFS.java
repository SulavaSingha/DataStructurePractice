import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    Graph g ;
    boolean[] visited;
    public BFS(Graph g){
        this.g=g;
        visited=new boolean[g.v.length];
    }
    public void bfsUtil(int source) {
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (!visited[source]) {
            queue.add(source);
            visited[source] = true;
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println(v);
            list = g.adj.get(v);
            if (list != null) {
                Iterator<Integer> i = list.iterator();
                while (i.hasNext()) {
                    int vertex=i.next();
                    if (!visited[vertex]) {
                        visited[vertex] = true;
                        queue.add(vertex);

                    }
                }
            }
        }
    }
}
