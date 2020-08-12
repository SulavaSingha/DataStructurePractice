import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void minimumMoves(List<Integer> arr1, List<Integer> arr2){
        int moves=0;
        for(int i=0;i<arr1.size();i++) {
            int num1 = arr1.get(i);
            int num2 = arr2.get(i);
            moves=calculateMoves(moves, num1,num2);
        }
        System.out.print(moves);
    }
    public int  calculateMoves(int m,int num1,int num2){
        while(num1!=0){
            int mod1= num1%10;
            int mod2=num2%10;
            int diff= Math.abs(mod1-mod2);
            m+=diff;
            num1=num1/10;
            num2=num2/10;
        }
        return m;
    }
    public static void main(String args){
        List<Integer> arr1= new ArrayList<>();
        List<Integer> arr2= new ArrayList<>();
        arr1.add(1234);
        arr1.add(4321);
        arr2.add(2345);
        arr2.add(3214);
        Solution sol = new Solution();
        sol.minimumMoves(arr1,arr2);

    }
}
