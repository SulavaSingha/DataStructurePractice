import java.util.*;

public class Solution {

    public static class Graph {
        int[][] adjacencyMatrix;
        int length;
        //boolean[] visited;
        int[] distance;

        public Graph(int size) {
            this.length = size + 1;
            adjacencyMatrix = new int[length][length];
            distance = new int[length];
            Arrays.fill(distance,-1);
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    adjacencyMatrix[i][j] = 0;
                }
            }

        }

        public void addEdge(int first, int second) {
            adjacencyMatrix[first][second] = 6;
            adjacencyMatrix[second][first] = 6;
        }

        public int[] shortestReach(int startId) { // 0 indexed
            //Map<Integer, List<Node>> map = new HashMap<>();
            distance[startId]=0;
            distance= bfs(startId);
           // distance = calculateDistance(map, startId);
            return distance;
        }



        public int []  bfs(int startId) {
           // visited = new boolean[length];
            Queue<Integer> queue = new LinkedList<>();

            int count = 0;
            queue.add(startId);
            while (!queue.isEmpty()) {
                int v = queue.remove();
               // visited[v] = true;
                for (int i = 1; i < length; i++) {
                    if (adjacencyMatrix[v][i] == 6 && distance[i]==-1) {
                        queue.add(i);
                        distance[i]=distance[v]+6;
                    }
                }
            }
            return distance;
        }

    }
        public static void main(String[] args) {
            // Find shortest reach from node s
            int startId = 2;
            Graph graph = new Graph(7);
           // graph.addEdge(7,4);
            graph.addEdge(1,2);
            graph.addEdge(1,3);
            graph.addEdge(3,4);
            graph.addEdge(2,5);
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
