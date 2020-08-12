class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int last=nums[nums.length-1];
        //first find the index of zero element
        while(i<nums.length-1){
            if(nums[i]==0){
                if(nums[i+1]!=0)
                inplace(nums,i);
            }
                        i++;
        }
        i=0;
        while(nums[i]!=last){
            i++;
        }
        i=i+1;
        while(i<nums.length){
            nums[i]=0;
            i++;
        }
    }
    public void inplace(int [] nums, int i){
       while(i<nums.length-1){
           nums[i]=nums[i+1];
           i++;
       }
        return;
    }
public static void main(String[] args){
        Solution s= new Solution();
        int [] nums= {0,0,1};
        s.moveZeroes(nums);
}
}
