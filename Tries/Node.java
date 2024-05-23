package Tries;

// Setting up node for trie
public class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    public Node(){};

    public boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }

    public Node get(char ch){
        return links[ch-'a'];
    }
    
    public void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}