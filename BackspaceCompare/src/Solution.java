import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
      S=  backspaceCompare(S);
     T=  backspaceCompare(T);


        if (S.equals(T)){
            return true;
        }

return false;
    }
    public String backspaceCompare(String S){
        Stack<Character> stack = new Stack<>();
       for(int i=0;i<S.length();i++){
           if(S.charAt(i)!='#'){
               stack.push(S.charAt(i));
           }
           else {
               if(!stack.isEmpty())
               stack.pop();
           }
       }// for
        String result =null;
       while(stack.isEmpty()){
           result=result+stack.pop();
       }
    return result;
    }
    public static void main(String [] args){
        Solution sol= new Solution();
        sol.backspaceCompare("a#b#c","e#d#c");
    }
}