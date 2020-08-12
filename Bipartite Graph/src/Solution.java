import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
   static class  Graph{
    public  boolean isBipartite() {
        /*int[][] graph = {{1,2,3},
                {0,2},
                {0,1,3},
                {0,2}};*/
        int graph[][]={{1},{0,3},{3},{1,2}};
        //System.out.println(graph.length);
         int[][] adjacencyMatrix= new int[graph.length][graph.length];
        Set<Integer>red = new HashSet<>();
        Set<Integer> black= new HashSet<>();
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph[i].length; j++) {
                adjacencyMatrix[i][graph[i][j]]=1;
               System.out.println(i+" "+graph[i][j]);
            }
            }
        int source= 0;
        int flag=0;
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int v=queue.poll();
            visited[v]=true;
            for(int i=0;i<graph.length;i++){
                if(adjacencyMatrix[v][i]>0){
                    if(flag==0){
                        red.add(i);
                        flag=1;}
                    else {
                        black.add(i);
                        flag=0;
                    }
                    if(!visited[i]){
                        queue.add(i);
                                   }
                    }
            }
        }
        for(int k: red){
            if(black.contains(k)){
                return false;
            }
        }
return true;
       }
    }
public static void main(String[] args){
        Graph g=new Graph();
        boolean result=g.isBipartite();
        System.out.println(result);
    }
}


