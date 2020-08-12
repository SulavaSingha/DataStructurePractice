import java.util.*;

public class KruskalAlgo {
    Graph g;
    Map<Integer,LinkedList<Edge>> path= new HashMap<>();
    Map<Integer,LinkedList<Integer>> sorted=new TreeMap<>();
    public KruskalAlgo(Graph g){
    this.g =g;
    path= g.adj;
    }
    public Map<Integer, LinkedList<Integer>>  findEdges(){
         path.entrySet().forEach(i->{
        LinkedList<Edge> list=i.getValue();
        list.stream().forEach(e-> {
            if(sorted.containsKey(e.getWeight())){
                LinkedList<Integer> ed= sorted.get(e.getWeight());
                ed.add(i.getKey());
                ed.add(e.getVertex());
                sorted.put(e.getWeight(),ed);
            }
            else {
                LinkedList<Integer> ed= new LinkedList<>();
                ed.add(i.getKey());
                ed.add(e.getVertex());
                sorted.put(e.getWeight(),ed );
            }
        });
         });
        return sorted;
    }
public void mSTAlgo() {
    Map<Integer, LinkedList<Integer>> sortedMap = findEdges();
    UnionGraph union = new UnionGraph(sortedMap);
    //calculate weight of mst
}
}
