class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
public class Solution {
    public ListNode reverseList(ListNode head) {
        /*ListNode prev=null;
        ListNode next=null;
        ListNode curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;*/
    if(head==null){
        return head;
    }
        if(head.next==null){
            return head;
        }


        ListNode curr=reverseList(head.next);
        head.next.next=head;
        head.next=null;

        return curr;
    }
    public static void main(String [] main){
        Solution sol= new Solution();
        ListNode head = new ListNode(1);
        ListNode curr=head;
        for(int i=2;i<=5;i++){
            curr.next= new ListNode(i);
            curr=curr.next;
        }
        sol.reverseList(head);
    }
}
