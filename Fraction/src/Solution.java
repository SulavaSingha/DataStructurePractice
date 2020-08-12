public class Solution {
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int n=arr.length-1;
        int positive=0;
        int negative=0;
        int zero=0;
        for(int i=0;i<=n;i++){
            if(arr[i]>0){
                positive++;
            }
            if(arr[i]<0){
                negative++;
            }
            if(arr[i]==0){
                zero++;
            }


        }
        float f;
        f=positive/n;
        System.out.format("%.6f%n",(double)positive/n);
        System.out.format("%.6f%n",(double)negative/n);
        System.out.format("%.6f%n",(double)zero/n);

    }

   // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 6;

        int[] arr = {-4 ,3 ,-9, 0, 4, 1 };
        plusMinus(arr);


    }
}
