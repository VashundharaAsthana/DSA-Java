//LeetCode 141-Find if there is a cycle/loop in the linked list
//Difficulty-Easy
//TC-O(n)
//SC-O(1)
//Use slow and fast pointer if they meet somewhere, cycle exists
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
