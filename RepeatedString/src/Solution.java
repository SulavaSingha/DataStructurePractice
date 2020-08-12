import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int k=0;
        int count=0;
        while(s.length()<=n){
            for(int i=0;i<3;i++){
                if(s.length()<=10){
                if(s.charAt(k)=='a'){
                    count++;
                }
                s=s+s.charAt(i);
                k++;
            } }

        }
        while(k<n){
            if(s.charAt(k)=='a'){
                count++;
                k++;
            }
        }
        System.out.println(s);
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = "aba";

        long n = 10;


        long result = repeatedString(s, n);

    }
}
