public class AdjacencyMatrix {
    //adjacency matrix for undirected graph
    int [] [] matrix = new int [][]{{0,2,0,8,4},
                                    {2,0,3,0,0},
                                    {0,3,0,5,1},
                                    {8,0,5,0,7},
                                    {4,0,1,7,0}};
    public static void main(String[] args){
        MST mst= new MST();
        mst.getMst();
    }
}
