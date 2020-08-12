import java.util.*;

public class MapForList {
    static class Node{

        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;

        }
    }
    static class VerticalHeight{
        Node node;
        int height;
        public VerticalHeight(Node node, int height){
            this.node=node;
            this.height=height;
        }
    }
    public static List<Node> listNodes= new ArrayList<>();
    public static Node m=null;
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.

        listNodes=fillUp(listNodes,root);
        Node ancestor= findlca(root,v1,v2);
        return ancestor;
    }
    static Node findlca(Node root, int v1,int v2){

        if(root==null){
            return null;
        }
        Node parentV1=findParent(listNodes,root,v1);
        Node parentV2=findParent(listNodes,root,v2);
        Node ancestor=null;
        if(parentV1==parentV2){
            return parentV1;}
        else {
            if(parentV1.data>parentV2.data){
              if(parentV1.right.data==parentV2.data){
                  return parentV1;
              }
            }
            else if(parentV1.left.data==parentV2.data){
                return parentV1;
            }
            else if(parentV2.data>parentV1.data){
                if(parentV2.right.data==parentV1.data){
                    return parentV2;
                }
            }
            else if(parentV2.left.data==parentV1.data){
                return parentV2;
            }
        }
        return root;
    }
    public static Node findParent(List<Node>map,Node root,int v){

        if(root==null){
            return null;
        }
        if(root.data==v) {
           for(Node n:map){

               if(v<n.data) {
                   if (n.left != null) {
                       if (n.left.data == v) {
                           return n;
                       }
                   }
               }
               else {
                   if(n.right!=null) {
                       if (n.right.data == v) {
                           return n;
                       }
                   }
               }
           }

        }
        if(v<root.data){
          m= findParent(map,root.left,v);
        }
        else if(v> root.data){
           m= findParent(map,root.right,v);
        }
        else{
       return null;
        }
        return m;
    }
    public static List<Node> fillUp(List<Node>listNodes,Node root) {
        if (root == null) {
            return null;
        }
        fillUp(listNodes,root.left);
       listNodes.add(root);
       fillUp(listNodes,root.right);

           return listNodes;
    }
    public static void verticalOrderTraversal(Node root){
    Map<Integer,List<Node>> treeMap= new TreeMap<>();
    Queue<VerticalHeight> q= new LinkedList<>();
    int val=0;
   treeMap= verticalTraversal(treeMap,q,root,val);
for(Map.Entry<Integer,List<Node>>e :treeMap.entrySet()){
    /*for(Node n:e.getValue()){*/
    Node n=e.getValue().get(0);
    System.out.print(n.data+" ");
/*}*/
}
    }
    public static Map<Integer,List<Node>> verticalTraversal(Map<Integer,List<Node>> treeMap,Queue<VerticalHeight> q,Node root,int val){
Node l=null;
Node r=null;
        q.add(new VerticalHeight(root,val));
        while(!q.isEmpty()){
            l=null;
            r=null;
            VerticalHeight v=q.remove();
            root=v.node;
            val=v.height;
            if(root.left!=null){
             l=root.left;}
            if(root.right!=null){
             r=root.right;}
            if(treeMap.containsKey(val)){
                List<Node> list= treeMap.get(val);
                list.add(root);
            }
            else {
                List<Node> list= new ArrayList<>();
                list.add(root);
                treeMap.put(val,list);
            }
            if(l!=null)
            q.add(new VerticalHeight(l,val-1));
            if(r!=null)
            q.add(new VerticalHeight(r,val+1));
        }
        return treeMap;
    }

    public static  void main(String [] args){
        List<Node> list= new ArrayList<>();
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node root =n2;
        n2.left=n1;
        n2.right=n4;
        n4.left=n3;
        n4.right=n5;
        n5.right=n6;
        //MapForList.lca(root,4,6);
        MapForList.verticalOrderTraversal(root);

        /*List<Node> list= new ArrayList<>();
        list.add(n1);
        list.add(n2);
        List<Node> list1= new ArrayList<>();
        list1.add(n3);
        list1.add(n4);
        map.put(n1,list1);
        map.put(n3,list);
        for(Map.Entry<Node,List<Node>> e: map.entrySet()){
            List<Node> l = e.getValue();
            if(l.contains(n4)){
                Node n=e.getKey();
            }*/
        }


}
