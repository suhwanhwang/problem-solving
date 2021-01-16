/*
https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList_(Node head) {
        
        List<Node> nodeList = new ArrayList<>();
        List<Node> newList = new ArrayList<>();
        Map<Node, Integer> nodeMap = new HashMap<>();
        
        Node cur = head;
        int index = 0;
        while (cur != null) {
            nodeList.add(cur);
            nodeMap.put(cur, index++);
            cur = cur.next;
        }
        
        Node dummyHead = new Node(0);
        cur = dummyHead;
        for (int i = 0; i < nodeList.size(); ++i) {
            Node node = nodeList.get(i);
            cur.next = new Node(node.val);
            newList.add(cur.next);
            
            cur = cur.next;
        }
                
        cur = head;
        Node newNode = dummyHead.next;
        while (cur != null) {
            Integer randomIndex = nodeMap.get(cur.random);
            newNode.random = (randomIndex != null ? newList.get(randomIndex) : null);
            cur = cur.next;
            newNode = newNode.next;
        }

        return dummyHead.next;
    }
    
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        
        for (Node cur = head; cur != null; cur = cur.next) {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
        }
        return map.get(head);
    }
    
}
