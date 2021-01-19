/*
https://leetcode.com/problems/lru-cache/

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?


*/
class LRUCache {
    static class Item {
        int key;
        int value;
        Item prev;
        Item next;
        
        Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    };
    
    Item head = new Item(0, 0);
    Item tail = new Item(0, 0);
    private void addHead(Item item) {
        item.prev = head;
        item.next = head.next;
        head.next.prev = item;
        head.next = item;
    }
    
    private Item remove(Item item) {        
        Item prev = item.prev;
        Item next = item.next;
        prev.next = next;
        next.prev = prev;
        return item;
    }
        
    Map<Integer, Item> map = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Item item = map.get(key);
            remove(item);
            addHead(item);
            return item.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        } else if (map.size() == capacity) {
            Item t = remove(tail.prev);
            map.remove(t.key);
        }
        
        Item item = new Item(key, value);
        addHead(item);
        map.put(key, item);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
