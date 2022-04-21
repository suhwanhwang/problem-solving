class MyHashSet {
    static class Node {
        List<Integer> list = new ArrayList<>();
    }
    
    private static final int TABLE_SIZE = 10000;
    private Node[] table = new Node[TABLE_SIZE + 1];
    
    public MyHashSet() {
        for (int i = 0; i < table.length; ++i) {
            table[i] = new Node();
        }
    }
    
    public void add(int key) {
        if (contains(key)) {
            return;
        } else {
            Node node = getNode(key);
            node.list.add(key);
        }
    }
    
    public void remove(int key) {
        Node node = getNode(key);
        node.list.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        Node node = getNode(key);
        for (int k : node.list) {
            if (k == key) {
                return true;
            }
        }
        return false;
    }
    
    private Node getNode(int key) {
        return table[getHash(key)];
    }
    
    private int getHash(int key) {
        return key % TABLE_SIZE;    
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
