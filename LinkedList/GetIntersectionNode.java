package LinkedList;

// https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/5015742/intersection-of-two-linked-lists-java-approach-o-n-m-time-o-n-space-explanation/

// Easy
// LinkedList, HashSets
// Iteration, store list nodes of A in hashset
// T:O(N+M), S:O(N)
// Iterate one list and store in set, then check in second list while iterating

// import java.util.HashSet;

import java.util.HashSet;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> setA = new HashSet<>();  
        while(headA != null){
            setA.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(setA.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}