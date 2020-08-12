public class Solution {
        static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode curr1=null;
        SinglyLinkedListNode head=null;
       //sort the list
            if(head1.data<head2.data){
                curr1=head1;
                while(head1.next!=null){
                    head1=head1.next;
                }
                head1.next=head2;
            }
    else {
        curr1=head2;
        while(head2.next!=null){
            head2=head2.next;
        }
                head2.next=head1;
            }
head=curr1;
    while(curr1!=null){
        SinglyLinkedListNode next= curr1.next;
       int temp=0;
       while(next!=null){
            if(curr1.data>next.data){
                temp=curr1.data;
                curr1.data=next.data;
                next.data=temp;

            }
           next=next.next;
       }
        curr1=curr1.next;
    }
    return head;
    }
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode current=head;
        while(current.next!=null){
            SinglyLinkedListNode next= current.next;
            if(current.data==next.data){
                current.next=next.next;
            }
            else {
                current = current.next;
            }
        }
        return head;
    }
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode current=head;
        DoublyLinkedListNode next=current.next;
        DoublyLinkedListNode previous=current.prev;
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if(current==null){

            current=node;
            node.next=null;
            node.prev=null;
        }
        else if(data<current.data){
            node.prev=current.prev;
            node.next=current;
            current.prev=node;
            head=node;
        }
        while(current.next!=null && data > current.data){
            current=current.next;
        }
if(current.next==null && data> current.data){
    current.next=node;
    node.prev=current;
    node.next=null;
}
else{
        node.prev=current.prev;
        current.prev.next=node;
        node.next=current;
        current.prev=node;
}

        return head;
    }
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode current=head;
        DoublyLinkedListNode temp=null;
        DoublyLinkedListNode next=null;
        while(current!=null){
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;
        current = current.prev; }
String s="1011011";
        Integer.parseInt(s);
        char[] str=s.toCharArray();
        for(int i=0;i<str.length;i++){
            int val=str[i];

        }
        return temp.prev;
    }
public static void main(String[] args){
    SinglyLinkedListNode node3 = new SinglyLinkedListNode(4);
    SinglyLinkedListNode node4 = new SinglyLinkedListNode(5);
    SinglyLinkedListNode node5= new SinglyLinkedListNode(6);
    SinglyLinkedListNode head1 = new SinglyLinkedListNode(3);
    SinglyLinkedListNode node1 = new SinglyLinkedListNode(3);
    SinglyLinkedListNode node2= new SinglyLinkedListNode(3);
    head1.next=node1;
    node1.next=node2;
    node2.next=node3;
    node3.next=node4;
    node4.next=node5;
    node5.next=null;
    SinglyLinkedListNode head2= new SinglyLinkedListNode(1);
    SinglyLinkedListNode l1= new SinglyLinkedListNode(2);
    SinglyLinkedListNode l2= new SinglyLinkedListNode(10);
    head2.next=l1;
    l1.next=l2;
    l2.next=null;
    //SinglyLinkedListNode result=Solution.mergeLists(head1,head2);
   // SinglyLinkedListNode result=Solution.removeDuplicates(head1);
    DoublyLinkedListNode dhead= new DoublyLinkedListNode(1);
    DoublyLinkedListNode dnode1= new DoublyLinkedListNode(2);
    DoublyLinkedListNode dnode2=new DoublyLinkedListNode(3);
  /*  DoublyLinkedListNode dnode3=new DoublyLinkedListNode(10);*/
    dhead.next=dnode1;
    dhead.prev=null;
   dnode1.prev=dhead;
   dnode1.next=dnode2;
   dnode2.prev=dnode1;
   dnode2.next=null;
  /* dnode2.next=dnode3;
   dnode3.prev=dnode2;
   dnode3.next=null;*/
  //  DoublyLinkedListNode result= Solution.sortedInsert(dhead,4);
    DoublyLinkedListNode result= Solution.reverse(dhead);
    while(result!=null){
        System.out.println(result.data);
        result=result.next;
    }


}
}
