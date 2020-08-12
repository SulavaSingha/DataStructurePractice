import java.util.Map;
import java.util.TreeMap;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        int k = 1;
        //int temp=k;
        for (int i = 1; i <= n; i++) {
            k=i;
            for (int j = 1; j <= i; j++) {
                while(k < 6){
                  System.out.print(" ");
                  k++;
                }
                System.out.print("#");
            }
            System.out.println();
            TreeMap<Integer,Integer> map=new TreeMap<>();
            Map.Entry<Integer,Integer> ent=  map.lastEntry();
        }
    }
    public static void main(String[] args){
            staircase(6);
        }
    }
