import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
static long totalCost=0;
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        boolean [] visited= new boolean[n+1];
        boolean[] cLib= new boolean[n+1];

       if(c_lib<c_road||cities.length==0){
           return n*c_lib;
       }
            int m = cities.length;
            int[][] adjacencyMatrix = new int[n + 1][n + 1];
            // long totalCost = 0;

            for (int i = 0; i < m; i++) {
                int start = cities[i][0];
                int end = cities[i][1];
                adjacencyMatrix[start][end] = c_road;
                adjacencyMatrix[end][start] = c_road;
            }
            int source = 1;
            //dfs(source,visited,adjacencyMatrix,totalCost);

            totalCost = dfs(source, visited, adjacencyMatrix, totalCost, cLib, c_lib, c_road);
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    totalCost = totalCost + c_lib;
                }
            }

        return totalCost;
            }





public static long dfs(int v, boolean[] visited,int[][] adj,long totalCost,boolean[] cLib,int c_lib,int c_road){
       if(!visited[v]){
        visited[v]=true;
        //stack.push(v);
for(int i=1;i<adj.length;i++){
    if(adj[v][i]>0){
        if(!visited[i]){
            if(!cLib[v]&& !cLib[i]){
                    totalCost = totalCost + c_lib + c_road;
                    cLib[v] = true;
                    cLib[i] = true;

            }

            else {
                totalCost=totalCost+c_road;
            }
            cLib[v]=true;
            cLib[i]=true;
          totalCost=  Math.max(totalCost,dfs(i,visited,adj,totalCost,cLib,c_lib,c_road));
        }
    }
}

}
       return totalCost;
    }

    public static void  main(String[] args){
      int[][] cities ={{2,1},
                { 5,3},
                {5 ,1},
               {3 ,4},
                {3 ,1},
                {5 ,4},
                {4, 1},
                { 5 ,2},
                {4 ,2  }};
    // int [][] cities=new int[][]{};
        long cost=roadsAndLibraries(5,92,23,cities);
        System.out.println(cost);
    }

}
