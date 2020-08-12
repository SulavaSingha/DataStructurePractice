import java.util.Arrays;

class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int total=0;
        for(int i=0;i<arr.length;i++){
            int count= arr[i]+1;
            if(count<=arr[arr.length-1])
            total=total+ binarySearch(count,arr,i,arr.length-1,total);
        }//first element
        return total;
    }//method
    public int binarySearch(int count, int[] arr,int start, int end,int total){
        if(count==arr[end]){
            return 1;
        }
        if(end>start) {

                int mid = start+(end - start) / 2;

            if (count == arr[mid]) {
                return 1;
            }
            if (count < arr[mid]) {
                return binarySearch(count, arr, start, mid, total);
            } else {
               return  binarySearch(count, arr, mid + 1, end, total);
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Solution sol= new Solution();
        int [] arr= {1,3,2,3,5,0};
        sol.countElements(arr);

    }
}