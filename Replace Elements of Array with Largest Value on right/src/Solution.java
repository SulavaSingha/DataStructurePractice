class Solution {
    public int[] replaceElements(int[] arr) {
        int numberToCompare=arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--){
            int prev=i-1;
            int temp=arr[prev];
            arr[prev]=numberToCompare;
            if(temp>numberToCompare){
                numberToCompare=temp;
            }
        }
       
        arr[arr.length-1]=-1;
        return arr;
    }
    public static void main(String [] args){
        Solution sol = new Solution();
        int[] arr= {17,18,5,4,6,1};
        sol.replaceElements(arr);
    }
}