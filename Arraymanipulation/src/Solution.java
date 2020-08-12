public class Solution {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int m,int[][] q) {
        long max=0;
        int[][] result=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=0;
            }
        }
        for(int i=0;i<m;i++){
            int  r=i+1;
            int a=q[i][0];
            int b=q[i][1];
            int k=q[i][2];
            while(r<=m){
            for(int j=a;j<=b;j++){
                result[r][j]=result[r][j]+k;
                if(max<result[r][j]){
                    max=result[r][j];
                }
            }
            r++;}
        }
        return max;
    }
    public static void main(String[] args){
        int n=5;
        int m=3;
        int [][] q= {{1, 2, 100},
                { 2, 5, 100},
                {3 ,4, 100}};
        long max=Solution.arrayManipulation(n,m,q);
    }

}
