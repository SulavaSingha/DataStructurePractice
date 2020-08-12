import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list= new LinkedList<>();
        Set<List<Integer>> set= new HashSet<>();
        // Set<Integer> set=new HashSet<>();
        for(int i=1;i<nums.length;i++){
            List<Integer> res= new LinkedList<>();
            for(int j=2;j<nums.length;j++){
                if((nums[i-1]+nums[i]+nums[j])==0){
                    res.add(0,nums[i-1]);
                    res.add(1,nums[i]);
                    res.add(2,nums[j]);
                    break;
                }

            }
            if(!res.isEmpty()){
                Collections.sort(res);
                set.add(res);
            }
        }

        for(List<Integer> l:set ){
            list.add(l);
        }
        return list;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int [] nums= new int[]{0,0,0,0};
       List<List<Integer>> list= sol.threeSum(nums);
       for(List<Integer> k: list){
          System.out.println(k);
       }

    }

}