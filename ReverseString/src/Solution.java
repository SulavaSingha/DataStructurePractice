class Solution {
    public void reverseString(char[] s) {
        String result= "";
        int n=s.length-1;
         result=reverseString(s,n,result);
        for(int i=0;i<result.length();i++){
            s[i]=result.charAt(i);
        }
    }
    public String reverseString(char[] s,int n,String result){

        if(n<0){
            return result;
        }
        result=result+s[n];
         return reverseString(s,n-1,result);



    }
public static void main(String[] args){
        Solution sol= new Solution();
        char[] s={'h','e','l','l','o'};
        sol.reverseString(s);
}
}