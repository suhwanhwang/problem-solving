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
    private Node head;
    private Node tail;
    private int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        node.prev = null;
        node.next = null;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }

    private Node removeTail() {
        Node temp = tail;
        Node prev = tail.prev;

        if (prev != null) {
            prev.next = null;
        }
        tail = prev;
        return temp;
    }

    private void addHead(Node node) {
        Node temp = head;
        head = node;
        node.prev = null;
        node.next = temp;
        if (temp != null) {
            temp.prev = node;
        }

        if (tail == null) {
            tail = node;
        }
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
            Node temp = removeTail();
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
