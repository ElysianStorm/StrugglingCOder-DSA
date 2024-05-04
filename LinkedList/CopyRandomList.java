package LinkedList;

// https://leetcode.com/problems/copy-list-with-random-pointer/solutions/5013483/copy-list-with-random-pointer-java-approach-o-n-time-o-n-space-explanation/

// Easy/Medium
// LinkedList, HashMaps
// Iteration, Store in hashmaps
// T:O(N), S:O(N)
// Iterate and store nodes in hashmap and then link from hashmap.

import java.util.HashMap;

class CopyRandomList {
    public ListNode copyRandomList(ListNode head) {
        if(head == null){
            return null;
        }
        HashMap<ListNode, ListNode> nodes = new HashMap<>();
        ListNode curr = head;

        while(curr != null){
            nodes.put(curr, new ListNode(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            nodes.get(curr).next = nodes.get(curr.next);
            nodes.get(curr).random = nodes.get(curr.random);
            curr = curr.next;
        }
        return nodes.get(head);
    }
}
