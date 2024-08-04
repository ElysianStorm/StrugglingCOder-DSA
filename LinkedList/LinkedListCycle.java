package LinkedList;

// https://leetcode.com/problems/linked-list-cycle/solutions/5547745/linked-list-cycle-java-approach-o-n-time-o-1-space-explanation/
// Easy
// Linked Lists
// T:O(N), S:O(1)
// Tortoise and rabbit
// Rabbit 2 step, Tortoise 1 step

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next == null){
            return false;
        }

        ListNode rabbit = head;
        ListNode tortoise = head;

        do{
            if(rabbit.next == null || rabbit.next.next == null){
                return false;
            }
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
        }while(tortoise != rabbit);

        return true;
    }
}
