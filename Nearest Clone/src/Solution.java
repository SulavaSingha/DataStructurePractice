
import java.io.*;
import java.util.*;

public class Solution {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        int n=graphNodes+1;
        int [][] adjMat=new int[n][n];
        int weight=0;
        Set<Integer> set=new HashSet<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        boolean[] visited= new boolean[n];
        Queue<Integer> queue =new LinkedList<Integer>();
        if(graphFrom.length==0 || graphTo.length==0||ids.length==0){
            return -1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adjMat[i][j]=0;
            }
        }
        for(int i=0;i<graphFrom.length;i++){
            adjMat[graphFrom[i]][graphTo[i]]=1;
            adjMat[graphTo[i]][graphFrom[i]]=1;
        }
        int source=findSource(ids,val);
        if(source<0){
            return -1;
        }

        queue.add(source);
        /*if(ids[source]==val){
            return 1;
        }*/
        while(!queue.isEmpty()){
            int v=queue.remove();
            visited[v]=true;
            //System.out.println(v);
            // weight=0;
            for(int i=1;i<n;i++){
                if(adjMat[v][i]==1 ){
                  if(map.containsKey(v)) {
                      List<Integer> list2 = map.get(v);
                      list2.add(i);
                      map.put(v,list2);
                  }
                  else {
                      List<Integer> list2= new ArrayList<>();
                      list2.add(i);
                      map.put(v,list2);
                  }

                    if(!visited[i]){
                        queue.add(i);
                        if(ids[i-1]==val && i!=source){
                            set.add(v);
                            set.add(source);
                            if(source==v){
                                return set.size();
                            }
                            List<Integer> result=map.get(source);
                            for(int k:result){
                                if(k==i){
                                    //  set.add(source);
                                    set.add(k);
                                    return set.size();
                                }
                                else {
                                    if (map.containsKey(k)) {
                                        List<Integer> path = map.get(k);
                                        if (path.contains(v)) {
                                            set.add(k);
                                            //  set.add(source);
                                        }
                                    }
                                }
                            }
                            return set.size();
                        }
                    }
                } }
              /*  else{
                    weight=0;
                }*/
        }

        return -1;

    }

    static int findSource(long[]ids,int val){
        for(int i=0;i<ids.length;i++){
            if(ids[i]==val){
                return i+1;
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* long ids[] ={1, 2, 3, 4};
        int[] graphFrom={1,1,4};
        int[] graphTo={2,3,2};
        int val=2;*/
       /* long ids[] ={1,2,3,3,2};
        int[] graphFrom={1,1,2,3};
        int[] graphTo={2,3,4,5};
        int val=2;*/

        long ids[] ={1,2,1,1};
        int[] graphFrom={1,1,4};
        int[] graphTo={2,3,2};
        int val=1;
        int result= findShortest(475431,graphFrom,graphTo,ids,val);
    System.out.println(result);
    }
}

