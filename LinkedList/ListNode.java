package LinkedList;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode random;       // For CopyRandomList question
    
    //Constructor 1
    ListNode() {}

    //Constructor 2
    ListNode(int val) {
        this.val = val; 
    }

    //Constructor 3
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }

    //Constructor 4
    ListNode(int val, ListNode next, ListNode random) {
        this.val = val; 
        this.next = next; 
        this.random = random;
    }
}