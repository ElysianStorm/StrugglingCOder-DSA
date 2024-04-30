package LinkedList;

// https://leetcode.com/problems/reorder-list/solutions/5012631/reorder-list-java-approach-o-n-time-o-1-space-explanation/

// Easy/Medium
// LinkedList
// Slow/Fast Pointers, Reversal, Merging
// T:O(N), S:O(1)
// Find mid using slow/fast, reverse after mid, merge alternating

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        // Get middle of linked list
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        // Reverse second half of linked list
        ListNode prev = null;
        ListNode curr = mid.next;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Disconnect middle element from later part of linked list
        mid.next = null;

        // Merge List
        ListNode temp_left;
        ListNode temp_right;
        ListNode left = head;
        ListNode right = prev;

        while(left != null && right != null){
            temp_left = left.next;
            left.next = right;
            temp_right = right.next;
            right.next = temp_left;

            left = temp_left;
            right = temp_right;
        }
    }
}
