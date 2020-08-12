import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] a) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(a[i])){
                int m=map.get(a[i]);
                map.put(a[i],m+1);
            }
            else {
                map.put(a[i],1);
            }
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int val=e.getValue();
            if(val==2){
                cnt=cnt+1;
            }
            if(val>2){
                cnt=cnt+(val/2);
                }
            }

        return cnt;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      /*  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));*/

       // int n = scanner.nextInt();
       /* scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");*/

        int[] ar = {1 ,1 ,3, 1, 2, 1, 3, 3, 3, 3};

       /* String[] arItems = scanner.nextLine().split(" ");
        *//*scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");*//*

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
*/
        int result = sockMerchant(10, ar);

      /*  bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
*/
        scanner.close();
    }
}
