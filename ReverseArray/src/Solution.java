public class Solution {
    static int[] reverseArray(int[] a) {
        int end=a.length-1;
        int temp=0;
        for(int i=0;i<(a.length)/2;i++){
            temp=a[i];
            a[i]=a[end-i];
            a[end-i]=temp;
        }
        return a;
    }
    public static void main(String []args){
        int [] a={1,2,3,4};
       int [] res= Solution.reverseArray(a);
       for(int i=0;i<a.length;i++){
           System.out.println(res[i]);
       }
    }
}
