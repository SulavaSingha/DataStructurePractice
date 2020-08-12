import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int data;
    TreeNode right;
    TreeNode left;
    public TreeNode(int data){
        this.data=data;
        /*this.right=null;
        this.left=null;*/
    }
}
public class Solution {
    //List<TreeNode> list= new ArrayList<>();
List<TreeNode> list= new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        if(n==0) {
            return new ArrayList<>();
        }
    return generateTrees(1,n);
                   }

    public List<TreeNode> generateTrees(int i,int n){
       List<TreeNode> list1= new ArrayList<>();
       if(i>n){
           list1.add(null);
           return list1;
        }

else {
    list1.add(new TreeNode(i));

}
        for(int start=i;start<=n;i++){
            List<TreeNode> leftNodes=generateTrees(start,start-1);
            List<TreeNode> rightNodes= generateTrees(start+1,n);
            for(TreeNode left:leftNodes){
                for(TreeNode right:rightNodes){
                    TreeNode root=new TreeNode(start);
                    root.left=left;
                    root.right=right;
                    list1.add(root);
                }
                list=list1;
            }

    }
        return list;
}

    public static void main(String [] args){
        Solution sol=new Solution();
        sol.generateTrees(3);
    }
}
