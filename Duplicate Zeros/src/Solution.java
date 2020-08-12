class Solution {
    public void duplicateZeros(int[] arr) {
        int dups=0;
        int len=arr.length-1;
        for(int i=0;i<=len-dups;i++){
            if(arr[i]==0){
                if(i+dups==len){
                    arr[len]=0;
                    len=len-1;
                    break;
                }
                dups++;
            }
        }

        int last=len-dups;
        for(int i=last;i>=0 &&len>=last ;i--){
            if(arr[i]==0){
                arr[len]=0;
                len=len-1;
                arr[len]=0;
                len--;
            }
            else {
                arr[len] = arr[i];
                len--;
            }
        }
    }
    public static void main(String[] args){
        Solution sol= new Solution();
        int [] arr={8,4,5,0,0,0,0,7};
        sol.duplicateZeros(arr);
    }
}