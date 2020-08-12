import java.util.Stack;

public class Scc {
    Graph g;
    Stack<Integer> stack;
    public Scc(Graph g){
        this.g=g;
        this.stack=new Stack<>();
    }
    public void getSCC() {
        DFS dfs = new DFS(g);
        System.out.println("The DFS to Find Strong Connected Component");
        stack = dfs.dfsStronglyConnected(g.v[0]);
        Transpose t = new Transpose(g);
        Graph gt = t.getTranspose();
        DFS transpose = new DFS(gt);
        System.out.println("The strongly connected components");
        boolean[] visited = {false, false, false, false, false};
        while (!stack.empty()) {
            if (!visited[stack.peek()]) {
                transpose.dfsUtilScc(stack.pop(),visited);
                System.out.println();
            }


        }
    }

}
