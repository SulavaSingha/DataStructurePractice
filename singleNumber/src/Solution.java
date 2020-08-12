import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(1<nums.length-1){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
            else {
                i=i+2;

            }
            if(i==nums.length-1){
                return nums[i];
            }

        }
        return -1;
    }
    public static void main(String[] args){
        Solution sol= new Solution();
        int [] nums={4,1,2,1,2};
        int r=sol.singleNumber(nums);
        System.out.println(r);
    }
}
