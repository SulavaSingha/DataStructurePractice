import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class UnionGraph {
          Set<Integer> disjointSet = new HashSet<>();
        Graph g;
        Map<Integer, LinkedList<Edge>> edge;
        Map<Integer,LinkedList<Integer>> sortedMap;
        int totalWeight=0;

        public UnionGraph(Graph g) {
            this.g = g;
            edge = g.adj;
        }
        public UnionGraph(Map<Integer,LinkedList<Integer>> sortedMap){
            this.sortedMap=sortedMap;
            init();
        }
      public void findUnion() {
            edge.entrySet().stream().forEach(e -> {
               findPath(e.getKey());
            });

      }
      public void printDisjointSet(Set<Integer> set){
          System.out.println("The final edges  without forming cycles are : " );
          set.stream().forEach(s-> {
              System.out.print(s+"->");
          });
      }
public void init() {
    for(Map.Entry<Integer,LinkedList<Integer>> edge: sortedMap.entrySet()){
        System.out.println("the weight is for current edge: " +edge.getKey() );
        disjointSet=findPath(edge.getValue(),edge.getKey());
    }
    printDisjointSet(disjointSet);
    System.out.println("The weight of minimum spanning tree is :" +totalWeight);

}
        private int findUnion(int root, int child) {
            int flag=0;
           if(disjointSet.isEmpty()){
               disjointSet.add(root);
               disjointSet.add(child);
                        }
           else if(disjointSet.contains(child)){
            System.out.println("It contains cycle for path: "+root+"-"+child +" dropping this edge");
            flag=1;
           }
           else {
               disjointSet.add(root);
               disjointSet.add(child);
           }
           return flag;

        }
        public void findPath(int key){
           LinkedList<Edge> path =edge.get(key);
           path.stream().forEach(i->{
               findUnion(key,i.getVertex());
           });
             }
             public Set<Integer> findPath(LinkedList<Integer> list,int weight) {
                 for (int i = 0; i < list.size() && i + 1 < list.size(); i++) {
                     int flag = findUnion(list.get(i), list.get(i + 1));
                     if (flag == 0) {
                         totalWeight = totalWeight + weight;
                     }
                 }
                 System.out.println(totalWeight);
                 return disjointSet;
             }

             }


