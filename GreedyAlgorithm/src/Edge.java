public class Edge {
    int start;
    int end;
    int weight;
    AdjacencyMatrix graph = new AdjacencyMatrix();
    int n=graph.matrix.length;
    public Edge(int start, int end ){
        this.start= start;
        this.end= end;
        this.weight=getPriority();
    }
    public Edge(){

    }
    public int getPriority(){
        if(end!=-1 && end <n ) {
            int p = graph.matrix[start][end];
            return p;
        }
        return Integer.MAX_VALUE;
    }


}
