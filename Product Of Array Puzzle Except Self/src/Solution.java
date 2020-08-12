import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output= new int[nums.length];
        Arrays.fill(output,1);
        int result=1;
        int i=0;


            for(int j=i;j<nums.length;j++){
                if(i==j){
                    j++;} //if
                if(j<nums.length)
                    result=result*nums[j];

            }//for
          /*  for(int k=i-1;k>=0;k--){
                result=result*nums[k];
            }//for*/
            output[i]=result;
            i++;
        }//while
        return output;
    }//method
public static void main(String[] args){
        int [] nums= {1,2,3,4};
        Solution sol= new Solution();
        sol.productExceptSelf(nums);

}

}
