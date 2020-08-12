

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            int val=preorder[i];
            generateTree(val,root);
            /*if(val<root.val){
                root.left=generateTree(val,root.left);

            }
            else {
                root.right=generateTree(val,root.right);

            }*/

        }
        return root;
    }
    public TreeNode generateTree(int val,TreeNode root ){
        TreeNode n= new TreeNode(val);
        if(root==null){
            return n;
        }
        if(val<root.val){
            root.left=generateTree(val,root.left);
           // return root.left;
        }
        else {
            root.right=generateTree(val,root.right);
           // return root.right;
        }
return root;
    }
    public static void main(String[] args){
        Solution sol= new Solution();
        int[] preorder={8,5,1,7,10,12};
        sol.bstFromPreorder(preorder);
    }
}