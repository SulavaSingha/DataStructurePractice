import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     /* //  List<String> strsList = new ArrayList<>();
       List<List<String>> list= new ArrayList<>();
        //strsList= Arrays.asList(strs);
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            List<String> set = new ArrayList<>();
            set.add(str);
            if(str!=null) {
                char[] ch1 = str.toCharArray();
                Arrays.sort(ch1);
                String a = new String(ch1);
                for (int j = i + 1; j < strs.length; j++) {
                    String str1 = strs[j];
                    if(str1!=null) {
                        char[] ch2 = str1.toCharArray();
                        Arrays.sort(ch2);
                        String b = new String(ch2);
                        if (a.equals(b)) {
                            set.add(str1);
                            strs[j] = null;
                            // strsList.remove(str1);
                        }
                    }
                }//innerfor
                list.add(set);
                strs[i]=null;
            }//if

        }*/
     Map<String,List<String>> map= new HashMap<>();
     List<List<String>> list1= new ArrayList<>();
     for(int i=0;i<strs.length;i++){
         String str= strs[i];
         char [] ch= str.toCharArray();
         Arrays.sort(ch);
         String str1= new String(ch);
         if(map.containsKey(str1)){
             List<String> list= map.get(str1);
             list.add(str);
             map.put(str1,list);
         }
         else {
            List<String> list= new ArrayList<>();
            list.add(str);
            map.put(str1,list);
         }

     }
     for(Map.Entry<String,List<String>> e: map.entrySet()){
         list1.add(e.getValue());
     }
        return list1;
    }//method
    public static void main(String[] args){
        Solution sol = new Solution();

        String [] s= {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result=sol.groupAnagrams(s);
    }
}//class