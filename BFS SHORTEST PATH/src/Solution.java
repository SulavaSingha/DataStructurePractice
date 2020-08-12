import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        int [][] adjacencyMatrix;
        int size;
        boolean [] visited;
        int[] shortest;
        public Graph(int size) {
            this.size=size;
            adjacencyMatrix= new int[size][size];
            visited =new boolean[size];
            shortest=new int[size];
            for(int i=0;i<size;i++){
 //               shortest[i]=-1;
                for(int j=0;j<size;j++){
                    adjacencyMatrix[i][j]=-1;
                }
            }
        }

        public void addEdge(int first, int second) {
            adjacencyMatrix[first][second]=6;

        }

        public int[] shortestReach(int startId) { // 0 indexed
            int count=0;
            visited[startId]=true;
            Queue<Integer> queue=new LinkedList<>();
            queue.add(startId);
            while(!queue.isEmpty()){
                int v=queue.remove();
                System.out.println(v);
                for(int i=startId;i<size;i++){
                    if(adjacencyMatrix[v][i]!=-1 &&v!=i){
                        if(!visited[i]){
                            visited[i]=true;
                            queue.add(i);
                                shortest[i] = count+ adjacencyMatrix[v][i];
                                count=shortest[i];

                        }
                        else {

                        }
                    }

                   else if(v!=-i) {
                       if(shortest[i]<=0) {
                           shortest[i] = adjacencyMatrix[v][i];
                       }
                        }
                    }


            }
            return shortest;


    }
    }

    public static void main(String[] args) {
      /*  Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {*/

            // Create a graph of size n where each edge weight is 6:

            Graph graph = new Graph(7);
            int m = 6;

            // read and set edges
           /* for (int i = 0; i < m; i++) {
               *//* int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
*/
                // add each edge to the graph
                graph.addEdge(0,1);
                graph.addEdge(1,0);
                graph.addEdge(1,2);
                graph.addEdge(2,1);
                graph.addEdge(2,3);
                graph.addEdge(3,2);
                graph.addEdge(0,4);
                graph.addEdge(4,0);
                graph.addEdge(5,6);


            // Find shortest reach from node s
            int startId = 0;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }


