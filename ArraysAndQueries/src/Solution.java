import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*static int[] simpleQueries(int[] a,int type,int x,int y){

    return a;
    }*/
    static void mergeFront(int [] a, int []b, int[] c){
        /*int temp=a[0];
        for(int i=0;i<=y;i++){
            a[i]=a[i+1];
        }
        a[y]=temp;*/
        int i=0;
        for( i=0;i<b.length;i++){
            a[i]=b[i];
        }
       for(int j=0;j<c.length;j++){
    a[i]=c[j];
    i++;
       }

    }
    static void mergeRear(int [] a,int[] b,int[] c,int x){
        int i=0;
        int k=x;
        for( i=0;i<c.length;i++){
            a[k]=c[i];
            k++;
        }
        //i=i-1;
        i=0;
        while(k<a.length){
            a[k]=b[i];
            i++;
            k++;
        }
       /* int n=(y-x)+1;
        int tempAr[] =new int[a.length];

            int j=0;
            for(int i=x;i<=y;i++){

                tempAr[j]=a[i];
                j++;
                //a[i]=0;
            }
            int k=x;
            for(int i=y+1;i<a.length;i++){
                a[k]=a[i];
                k++;
                //a[i]=0;
            }
            k=a.length-1;
            j=j-1;
            for(int i=0;i<n;i++){
                a[k]=tempAr[j];
                j--;
                k--;
            }
        }
*/
    }
static void split(int type,int[] a, int x, int y){
    int [] b= new int[y-x+1];
    int i=x;
    int j=0;
    while(i<=y){
        b[j]=a[i];
        a[i]=a[i+1];
        i++;
        j++;
    }
        if(type==1){
        int [] c= new int[x];
        for(i =0;i<x;i++){
            c[i]=a[i];
        }
        mergeFront(a,b,c);
        }
        else {
            int[] c=new int[a.length-1-y];
            int k=0;
            for(i=y+1;i<a.length;i++){
                c[k]=a[i];
                k++;
            }
            mergeRear(a,b,c,x);
        }

}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int N = Integer.parseInt(nd[0]);

        int M = Integer.parseInt(nd[1]);

        int[] a = new int[N];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
            /* System.out.print(a[i]+" "); */
        }
       // System.out.println();
        for (int i = 0; i < M; i++) {
            int type = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            split(type,a,x-1,y-1);
        }
        int diff=Math.abs(a[0]-a[N-1]);
        System.out.print(diff);
        System.out.println();
        for(int i=0;i<N;i++){
            System.out.print(a[i]+" ");
        }

       /* for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close(); */

        scanner.close();
    }
}