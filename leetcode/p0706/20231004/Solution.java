class MyHashMap {
    private static class Entry {
        int key;
        int value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int MAX_SIZE = 1000;

    private List<List<Entry>> map = new ArrayList<>();
    
    public MyHashMap() {
        for (int i = 0; i < MAX_SIZE; ++i) {
            map.add(new ArrayList<>());
        }
    }
    
    public void put(int key, int value) {
        List<Entry> entries = map.get(getHash(key));
        for (Entry entry : entries) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        entries.add(new Entry(key, value));
    }
    
    public int get(int key) {
        List<Entry> entries = map.get(getHash(key));
        for (Entry entry : entries) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        List<Entry> entries = map.get(getHash(key));
        for (int i = 0; i < entries.size(); ++i) {
            Entry entry = entries.get(i);
            if (entry.key == key) {
                entries.remove(i);
                return;
            }
        }
    }
    
    private int getHash(int key) {
        return key % MAX_SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
