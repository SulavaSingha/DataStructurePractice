public class StringShift {
    public String shift(String s, int[][] st) {
        String ans="";
        for(int i=0;i<st.length;i++){
            int sr=st[i][0];
            int r=st[i][1];
            if(sr==0){
              s=leftrotate(s,r);
            }
            if(sr==1){
                s=rightrotate(s,r);
            }
        }
        return ans;
    }
    static String leftrotate(String str, int d)
    {
        String ans= str.substring(d) + str.substring(0,d);
        return ans;

    }

    // function that rotates s towards right by d
    static String rightrotate(String str, int d)
    {
        return leftrotate(str, str.length() - d);
    }
    public static void main(String[] args){
        String s = "abcdefg";
        int [][]shiftArr = {{1,1},
                {1,1},
                {0,2},
                {1,3}};
        StringShift sh=new StringShift();
        sh.shift(s,shiftArr);
    }
}
