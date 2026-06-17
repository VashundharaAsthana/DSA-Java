//LeetCode-142
//TC-O(n)
//SC-O(1)
//Difficulty-Meedium
//First find if the cycle exist if yes, use p1 and p2 pointers to identify at which node cycle starts
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                ListNode p1= head;
                ListNode p2=slow;
                while(p1!=p2){
                    p1=p1.next;
                    p2=p2.next;
                }
                return p1;//or p2
            }
        }
        return null;
    }
}
