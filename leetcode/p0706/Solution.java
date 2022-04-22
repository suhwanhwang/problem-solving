class MyHashMap {
    private static class Item {
        int key;
        int value;
        Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private static class Node {
        List<Item> list = new ArrayList<>();
    }
    
    private static final int TABLE_SIZE = 100000;
    private Node[] table = new Node[TABLE_SIZE + 1];
    
    public MyHashMap() {
        for (int i = 0; i < table.length; ++i) {
            table[i] = new Node();
        }
    }
    
    private int getHash(int key) {
        return key % TABLE_SIZE;
    }
    
    private Node getNode(int key) {
        return table[getHash(key)];
    }
    
    private Item getItem(int key) {
        Node node = getNode(key);
        for (int i = 0; i < node.list.size(); ++i) {
            if (node.list.get(i).key == key) {
                return node.list.get(i);
            }
        }
        return null;
    }
    
    public void put(int key, int value) {
        Item item = getItem(key);
        if (item == null) {
            Node node = getNode(key);
            node.list.add(new Item(key, value));
        } else {
            item.value = value;
        }
    }
    
    public int get(int key) {
        Item item = getItem(key);
        if (item != null) {
            return item.value;
        } else {
            return -1;
        }
    }
    
    public void remove(int key) {
        Node node = getNode(key);
        Item item = getItem(key);
        node.list.remove(item);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
