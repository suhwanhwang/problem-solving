class LRUCache {
    private static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private Map<Integer, Node> map = new HashMap<>();
    private final int capacity;
    private final Node head = new Node(0,0);
    private final Node tail = new Node(0,0);
    private int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private Node remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        return node;
    }

    private void addHead(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node org = map.get(key);
        if (org != null) {
            remove(org);
            count--;
        }
        Node node = new Node(key, value);
        addHead(node);
        map.put(key, node);

        count++;
        if (count > capacity) {
            Node temp = remove(tail.prev);
            map.remove(temp.key);
            count--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
