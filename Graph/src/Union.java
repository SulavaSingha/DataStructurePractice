import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Union {
    Set<Set<Integer>> disjointSet;
    Graph g;
    Map<Integer, LinkedList<Integer>> edge;

    public Union(Graph g) {
        this.g = g;
        edge = g.adj;

    }

    public void init() {
        findUnion();
    }

    public void findUnion() {
        edge.entrySet().stream().forEach(e -> {
            Set<Integer> set = new HashSet<>();
            set.add(e.getKey());
            disjointSet.add(set);
        });
        edge.entrySet().stream().forEach(e -> {
            disjointSet=findUnion(disjointSet,e.getKey());
        });
        System.out.println("The set");
        disjointSet.stream().forEach(s-> {
            System.out.println(s);
       });
    }

    private Set<Set<Integer>> findUnion(Set<Set<Integer>> set, int key) {
        LinkedList<Integer>list= new LinkedList<>();
      list=edge.get(key);
      for(Set<Integer>s :set){
          if(s.contains(key))
          {
              list.stream().forEach(i-> {
                  if(!s.contains(i)){
                      s.add(i);
                  }
                  else {
                      System.out.println("Contains cycle");
                  }
              });
          }
        }
      return set;
    }
}
