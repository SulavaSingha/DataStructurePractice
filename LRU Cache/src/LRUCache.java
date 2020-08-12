import java.util.*;

public class LRUCache {
        Map<Integer,Integer> map;
        int capacity =0;
        public LRUCache(int capacity) {
            this.capacity= capacity;
            map=new LinkedHashMap(capacity, (float) 0.75,true);
        }
        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            return map.get(key);
        }
        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() == capacity)
                    map.remove(map.get());
                map.put(key, value);
                }


            else {
                if(map.get(key)!=value){
                    map.put(key,value);
                }

                            }
        }
        public static void main(String[] args){
            LRUCache cache = new LRUCache(2);
           /* cache.put(1,1);
            cache.put(2,2);
            cache.get(1);
            cache.put(3,3);
            cache.get(2);
            cache.put(4,4);
            cache.get(1);
           System.out.println(cache.get(3));
            cache.get(4);*/
            cache.put(2,1);
            cache.put(1,2);
            cache.put(2,3);
            cache.put(4,1);
            cache.get(1);
            cache.get(2);
            /*cache.put(2,1);
            cache.get(2);
            cache.put(3,2);
            cache.get(2);
            cache.get(3);*/




        }
    }


