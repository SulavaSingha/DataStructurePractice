import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    public TreeNode(int val){
        this.val=val;
    }
}
public class Solution {
         public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> path1= new ArrayList<>();
            List<TreeNode> path2=new ArrayList<>();
            boolean isPath1=  checkPath(root,p,path1);
            boolean isPath2=checkPath(root,q,path2);
           if(!isPath1 || !isPath2){
               return null;
           }
           int i=0;
           for(i=0;i<path1.size() && i<path2.size();i++){
               if(!path1.get(i).equals(path2.get(i))){
                   break;
               }
           }
            return path1.get(i-1);
        }
        public boolean checkPath(TreeNode root,TreeNode p,List<TreeNode>path){
             Integer.M
            if(root==null){
                return true;
            }

            path.add(root);
            if(root.val==p.val){
            return true;
            }
           if(root.left!=null &&  checkPath(root.left,p,path))
           {
               return true;
           }
           else if (root.right!=null && checkPath(root.right,p,path)){
               return true;
           }

            return false;
        }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        Solution sol= new Solution();
       TreeNode n =sol.lowestCommonAncestor(root,root.left,root.right);
       System.out.println(n.val);
    }
}

