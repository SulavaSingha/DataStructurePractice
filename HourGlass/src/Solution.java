public class Solution {
    static final int ROWS=6;
    static final int COLUMNS=6;
    static int max=Integer.MIN_VALUE;
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        for(int row=0;row<=(ROWS/2);row++){
            for(int col=0;col<=(COLUMNS/2);col++){
                arr[row][col]= calculateHourGlassValue(row,col,arr);
                if(arr[row][col]>max){
                    max=arr[row][col];
                }
            }
        }
        return max;
    }
    static int calculateHourGlassValue(int i, int j, int [][]a){
        int total=0;
        for(int r=i;r<i+(ROWS/2);r++){
            for(int c=j;c<j+(COLUMNS/2);c++){

                if(r==i+1&&c==j+1){
                    total=total+a[i+1][j+1];
                }
                else if(r!=i+1){
                    total= a[r][c]+total;
                }

            }
        }
        return total;
    }

    public static void main(String[] args){
       int [][] arr= { {1, 1, 1, 0, 0, 0},
               {0, 1, 0, 0, 0, 0},
               {1 ,1, 1, 0, 0, 0},
               {0, 0, 2, 4, 4, 0},
               {0 ,0 ,0 ,2 ,0, 0},
               {0, 0, 1, 2, 4, 0}};
       Solution.hourglassSum(arr);

    }
}
