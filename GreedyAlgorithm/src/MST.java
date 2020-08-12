import javafx.util.Pair;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MST {
    AdjacencyMatrix adj= new AdjacencyMatrix();
    int n= adj.matrix.length;
    Edge[] mst= new Edge[n];
    PriorityQueue<Edge> pq= new PriorityQueue<Edge>(n, new Comparator<Edge>() {
        @Override
        public int compare(Edge e1, Edge e2) {
         return   e1.weight-e2.weight;
        }
    });
    PriorityQueue<Edge> pq1 =  new PriorityQueue<Edge>(n, new Comparator<Edge>() {
        @Override
        public int compare(Edge e1, Edge e2) {
            return   e1.weight-e2.weight;
        }
    });
public void getMst() {
    //initialize the priority Queue
    for (int i = 1; i < n; i++) {
        pq.add(new Edge(i, Integer.MAX_VALUE));
        //initialize the mst array
        mst[i-1] = new Edge(i, -1);
    }
    pq.add(new Edge(0,0));
      while (!pq.isEmpty()) {
        int u = pq.remove().start;
             for (int v = 0; v < n; v++) {
            int weight = adj.matrix[u][v];
            if (weight > 0) {
                    for(Edge pv: pq){
                    if ((weight < pv.weight) &&( pv.start==v)) {
                        //pq1.remove(pv);
                       pv.end=u;
                       pv.weight=weight;
                       pq1.add(new Edge(u,v));

                    }
                }

            }

        }

    }
    for(int i=0 ;i<n ;i++) {
        mst[i] = pq1.remove();
        System.out.println(mst[i].start + "->" + mst[i].end + ": " + mst[i].weight);
    }

}
public void printMstTree(Edge[] mstTree){
    for(int i=0;i<mstTree.length;i++){

    }
}
}
