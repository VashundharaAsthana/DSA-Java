//LeetCode-19 remove nth node from End of list
//Difficulty-Medium
//TC-0(n) SC-O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode temp=head;
        if(head==null){
            return head;
        }
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(size== n){
            head=head.next;
            return head;
        }
        int delNode=size-n;
        temp=head;
        for(int i=0;i<delNode-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}
