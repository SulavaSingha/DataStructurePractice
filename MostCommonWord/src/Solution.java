import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> frequency = new HashMap<>();
        Set<String> set= new HashSet<>();
        String[] para= paragraph.split(" |\\!|\\?|\\'|\\,|\\;|\\.|'\"'\"'");
        for(int i=0;i<para.length;i++){
            String s=para[i].toLowerCase();
            if(!s.equals("")) {
                int count = frequency.getOrDefault(s, 0) + 1;
                frequency.put(s, count);
            }
        }
        for(String s: banned) {
            set.add(s);
        }
        int maxfreq=0;
        String ans="";
        for(Map.Entry<String,Integer> entry:frequency.entrySet() ){
            if(!set.contains(entry.getKey())){
                if(entry.getValue()>maxfreq){
                    maxfreq=entry.getValue();
                    ans=entry.getKey();
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution sol= new Solution();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
       String[] banned = {"hit"};
        sol.mostCommonWord(paragraph,banned);
    }
}