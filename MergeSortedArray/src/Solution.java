class Solution {
    int i=0;
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int numofzeros=nums1.length-m;
        merge(nums1,m,nums2,n,numofzeros);

    }
    public void merge(int[] nums1, int m, int[] nums2, int n,int zero){
        if(m-1<0 && n-1<0){
            return;
        }
        else if(m-1<0 && n-1>=0){
            //copy nums2 to nums1;
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
        }
        else if(n-1<0 && m-1>=0){
            return;
        }
        else if(nums1[m-1]<nums2[n-1]){
            merge(nums1,m,nums2,n-1,zero-1);
            //determine position of zeroll

                int position = nums1.length - zero;
                //shift one by one;
               /* while (position >= n - 1) {
                    nums1[position] = nums1[position - 1];
                    position = position - 1;
                }*/

           nums1[position]=nums2[n-1];

        }
        else if(nums1[m-1]>nums2[n-1]){
            merge(nums1,m-1,nums2,n,zero);

                int position = nums1.length - zero;
                //shift one by one;
                while (position >= m - 1) {
                    nums1[position] = nums1[position - 1];
                    position = position - 1;
                }

            //nums1[m+1]=nums2[n];
            //zero=zero-1;
        }
    }
    public static void main(String[] args){
        Solution sol= new Solution();
        int [] nums1={1,2,3,0,0,0};
        int [] nums2={2,5,6};
        sol.merge(nums1,3,nums2,3);
    }
}