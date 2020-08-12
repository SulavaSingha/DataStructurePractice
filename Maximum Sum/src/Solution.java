import java.util.*;

public class Solution {
    public int calculateDiff(int [] arr, int[][]sub){
        int diff=0;
        int sumAlice=0;
        int sumBob=0;
        for(int i=0;i<sub.length;i++) {
            int x = sub[i][0];
            int y = sub[i][1];
            for (int j = x; j <= y; j++) {
                sumAlice+=arr[j];
            }
        }
    //calculate for bob
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int item:arr){
            pq.add(item);
        }
        int[] a= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            a[i]=pq.remove();
        }
        for(int i=0;i<sub.length;i++){
            int x=sub[i][0];
            int y=sub[i][1];
            for (int j = x; j <= y; j++) {
                sumBob+=a[j];
            }
        }
        diff= Math.abs(sumAlice-sumBob);
        return diff;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String [] args){
        String[] nd = scanner.nextLine().split(" ");
        int N = Integer.parseInt(nd[0]);
        int K = Integer.parseInt(nd[1]);
        int arr[] = new int[N];
        String[]arrRowItems = scanner.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(arrRowItems[i]);
                    }
        int [][] subArray= new int[K][2];
        for(int i=0;i<K;i++){
            String [] a=scanner.nextLine().split(" ");
            subArray[i][0]=Integer.parseInt(a[0]);
            subArray[i][1]=Integer.parseInt(a[1]);
        }
        Solution sol= new Solution();
       int diff= sol.calculateDiff(arr,subArray);
       System.out.println(diff);
    }
}
