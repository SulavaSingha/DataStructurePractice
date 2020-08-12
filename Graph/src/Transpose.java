import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Transpose {
    Graph g;
    Graph gt;
    Map<Integer,LinkedList<Integer>> mapT;

    public Transpose(Graph g){
        this.g=g;
    }
    public Graph getTranspose(){
        Map<Integer, LinkedList<Integer>> map=g.adj;
       mapT= new HashMap<>();
       gt=new Graph();
      map.entrySet().stream().forEach(e-> {

                  e.getValue().stream().forEach(i -> {
                      gt.addEdge(i,e.getKey());
                                      });
              });
               return gt;
            }
}
