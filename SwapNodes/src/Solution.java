import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the swapNodes function below.
     */
    static class Node{
        Node left;
        Node right;
        int data;
        int depth;
        public Node(int data,int depth, Node left, Node right){
            this.depth=depth;
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }
    static  int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         *
         */
        int[][] a= new int[queries.length][indexes.length];
        Node root= new Node(1,1,null ,null);
        Node parent=root;
        Queue<Node> q= new LinkedList<>();
        int N=0;
        q.add(parent);
        while(N< indexes.length){
            //while (!q.isEmpty()) {
                Node n = q.poll();
                int leftData= indexes[N][0];
                int rightData=indexes[N][1];
                if(leftData!=-1){
                    parent.left= new Node(leftData,parent.depth+1,null,null);
                }
                if(rightData!=-1){
                    parent.right=new Node(rightData,parent.depth+1,null,null);
                }
                if(parent.left !=null &&parent.left.data!=-1){
                    parent=parent.left;
                    q.add(parent);
                }
                else if(parent.right!=null && parent.right.data!=-1){
                    parent=parent.right;
                    q.add(parent);
                }
                N=N+1;
        }

        for(int i=0;i<queries.length;i++) {
            Node r = swap(root, queries[i]);
            root=r;
            List<Integer> list1= new ArrayList<>();
            List<Integer> list=inorderTraversal(root,list1);
            a[i]=list.stream().mapToInt(l->l).toArray();
        }

        return a;
    }

    public static  Node swap(Node parent,int k){
        if(parent==null){
            return null;
        }
    swap(parent.left,k);
    swap(parent.right,k);

if(parent.depth>=k || parent.depth%k==0){
    Node temp=parent.left;
    parent.left=parent.right;
    parent.right=temp;
}
return parent;
    }
public static List<Integer> inorderTraversal(Node root, List<Integer> l){
    if(root==null){
        return null;
    }
    inorderTraversal(root.left,l);
    l.add(root.data);
     inorderTraversal(root.right,l);
    return l;
}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


     int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
                //System.out.println(indexes[indexesRowItr][indexesColumnItr]);
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

      int[][] result = swapNodes(indexes, queries);
 for(int i=0;i<queries.length;i++){
     for(int j=0;j<indexes.length;j++){
         System.out.print(result[i][j]+" ");
     }
     System.out.println();
 }

       /* for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();*/
    }
}

