
class Solution {
    public int uniquePathsWithObstacles(int[][] dp) {
        int m=dp.length;
        int n=dp[0].length;
        dp[0][0]=1;
        for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                if(i!=0 || j!=0 && dp[i][j]==1){
                    dp[i][j]=0;
                    //break;
                }
                else if(i>0 && j>0){
                    if(dp[i][j]!=1)
                        dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
                else if(i==0 && j>0){
                    if(dp[i][j]!=1){
                        dp[i][j]=dp[i][j-1];
                    }
                }
                else if(j==0 && i>0){
                    if(dp[i][j]!=1){
                        dp[i][j]=dp[i-1][j];
                    }
                }
                else if(i==0 && j==0){
                    dp[i][j]=1;
                }

            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String [] args){
        Solution sol= new Solution();
           /* int [][] arr={{0,0,0},
                    {0,1,0},
                    {0,0,0}};*/
        int [][] arr={{0,1}};
           int len= sol.uniquePathsWithObstacles(arr);
            System.out.println(len);
    }
}