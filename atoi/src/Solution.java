class Solution {
    public int myAtoi(String str) {
        String result="";
        if(str.length()==0 ||str==null){
            return 0;
        }
        int i=0;
        while(i<str.length()){
            char c= str.charAt(i);
            if (!Character.isSpaceChar(c)|| !Character.isLetter(c) || !Character.isWhitespace(c)){
                if(c=='+'||c=='-'||Character.isDigit(c)){
                    result+=c;
                }
                i++;
            }
        }
        Integer.MI
        //str.indexOf()
        return Integer.parseInt(result);
    }
    public static void main(String[] args){
        Solution sol= new Solution();
        sol.myAtoi("words and 987");
    }
}

