import java.util.ArrayList;
import java.util.List;
class Node {
    int data;
    Node right;
    Node left;
    Node (int data){
        this.data=data;
        this.left=null;
        this.right=null;

    }
}
public class Solution {
    int number=0;
    int i=1;

    public int generateTrees(int n){
        // the function you have is f(i,n)
        //Number of nodes that are possible are 1 to n
        //with recursion we can have (i-1) ways and (n-i) ways in left and right
        //left ways would be (i-1) ways and right ways would be (n-i) ways
       // List<Integer> list=new ArrayList<>();
       /* if(n==0){
            return null;
        }*/
  /* for(int i=1;i<=n;i++) {
       left.add(generateTrees(i - 1));
          }
   for(int i=1;i<=n;i++){
       right.add(generateTrees(n - i));
   }
*/
  if(n==0){
      return 0;
  }
  if(n==1){
      return 1;
  }
  int [] f= new int[n+1];
  f[0]=0;
  f[1]=1;
  for(int i=2;i<=n;i++){
     f[i]=f[i-1]+f[n-i];
  }
  for(int i=0;i<f.length;i++){
      number=number+f[i];
  }
  for(int i=1;i<=n;i++){
      bst(i,n+1);
  }
  return number;
    }
public Node bst(int data,int n){
        if(data==0){
            return null;
        }
        else {
            Node root = new Node(data);

            root.left = bst(data - 1, n);
            root.right = bst(n - data, n);
            return root;
        }

}
    public static void main(String[] args){
        Solution sol= new Solution();
        sol.generateTrees(4);
    }
}
