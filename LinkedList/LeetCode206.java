//LeetCode-206-Reverse a singly linked list
//TC=O(n) SC= O(1)
//Difficulty -easy
//use three pointers to solve this problem
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode prev=null;
        ListNode next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
     }
}
