import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> list= new ArrayList<>();
    List<Integer> l= new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combination(1,n,k,l);
        return list;
    }
    public void combination(int start,int n,int k,List<Integer> l){
        if(l.size()==k){ //2,yes
            list.add(new ArrayList(l));
        }
        for(int i=start;l.size()<k && i<=n;i++){
            l.add(i);
            combination(start+1,n,k,l);
            l.remove(l.size()-1);
        }
    }
    public static void main(String[] args){
        Solution sol= new Solution();
        sol.combine(4,2);
    }
}