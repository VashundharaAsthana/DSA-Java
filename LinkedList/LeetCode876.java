//LeetCode-876->Middle of Linked List
//TC-O(n)
//SC-O(1)
//two pointer approach-slow and fast pointer used where the fast pointer moves twice as quickly as slow,so when the slow reaches middle fast already reached to end
class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast =head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        } return slow;
    }
}
