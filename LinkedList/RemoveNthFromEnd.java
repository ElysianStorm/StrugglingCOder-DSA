package LinkedList;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/solutions/5013047/remove-nth-node-from-end-of-list-java-approach-o-n-time-o-1-space-explanation/

// Easy/Medium
// LinkedList
// Iteration, edge cases
// T:O(N), S:O(1)
// Iterate to end, compute index from start, remove while taking care of edge cases

class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode node, int n) {
        if(node.next == null){
            return null;
        }

        ListNode head = node;
        int size = 1;
        while(node.next != null){
            node = node.next;
            size++;
        }

        int front_remove = size - n - 1;
        ListNode tail = head;

        while(front_remove > 0){
            front_remove--;
            tail = tail.next;
        }

        if(size == n){
            head = head.next;
        }
        else{
            tail.next = tail.next.next;
        }

        return head;
    }
}
