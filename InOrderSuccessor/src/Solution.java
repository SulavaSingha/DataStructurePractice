import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
       class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
             val = x;
         }
     }
    class Solution {
        List<TreeNode> nodes= new ArrayList<>();
        public void inorder(TreeNode root){
            if(root==null)
                return;
            inorder(root.left);
            nodes.add(root);
            inorder(root.right);
        }
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if(root==null)
                return null;
            inorder(root);
            int low=0;
            int high=nodes.size()-1;
            TreeNode n=binarySearch(p,low, high);
    Character.is
            return n;
        }
        public TreeNode binarySearch(TreeNode p, int low, int high){
            int mid=(low+high-low)/2;
            while(low<high){
                if(nodes.get(mid)==p){
                    return nodes.get(mid);
                }
                else if(p.val<nodes.get(mid).val){
                    high=mid+1;
                }
                else{
                    low=mid;
                }
                low++;
                high--;
            }
            return null;
        }

           public static void main(String[] args){
            TreeNode root= new TreeNode(2);
            root.left= new TreeNode(1);
            root.right= new TreeNode(3);
            Solution sol= new Solution();
            sol.inorderSuccessor(root,root.left);
    }
}
