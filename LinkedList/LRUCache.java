package LinkedList;

// https://leetcode.com/problems/lru-cache/solutions/5047016/lru-cache-java-approach-o-1-time-o-n-space-explanation/

// Hard (too much to do, not intuitive as well)
// Linked Lists, Hashmaps
// Create data structure
// T:O(1), S:O(N)
// Use map for getting elements and list for maintaining LRU status for nodes

import java.util.HashMap;
import java.util.Map;

class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    private Map<Integer, Node> m;
    private Node LRU;
    private Node MRU;
    private int size;

    public LRUCache(int capacity) {
        size = capacity;
        m = new HashMap<>();
        LRU = new Node(-1, -1);
        MRU = new Node(-1, -1);
        LRU.next = MRU;
        MRU.prev = LRU;
    }

    private void deleteNode(Node p) {
        Node pre = p.prev;
        Node nex = p.next;
        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(Node newnode) {
        Node temp = LRU.next;
        LRU.next = newnode;
        newnode.prev = LRU;
        newnode.next = temp;
        temp.prev = newnode;
    }

    public int get(int key) {
        if (!m.containsKey(key))
            return -1;

        Node p = m.get(key);
        deleteNode(p);
        addNode(p);
        m.put(key, LRU.next);
        return LRU.next.val;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node c = m.get(key);
            deleteNode(c);
            c.val = value;
            addNode(c);
            m.put(key, LRU.next);
        } else {
            if (m.size() == size) {
                Node prev = MRU.prev;
                deleteNode(prev);
                Node l = new Node(key, value);
                addNode(l);
                m.remove(prev.key);
                m.put(key, LRU.next);
            } else {
                Node l = new Node(key, value);
                addNode(l);
                m.put(key, LRU.next);
            }
        }
    }
}

// Example usage:
// LRUCache cache = new LRUCache(capacity);
// int value = cache.get(key);
// cache.put(key, value);