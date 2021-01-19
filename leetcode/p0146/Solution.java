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
    
    Item head = null;
    Item tail = null;
    private void addHead(Item item) {
        if (head != null) {
            head.prev = item;
            item.next = head;
            head = item;
        } else {
            head = item;
            tail = item;
            item.prev  = item.next = null;
        }
    }
    
    private Item removeHead() {
        if (head == null) {
            return null;
        }
        
        Item tmp = head;
        if (head.next != null) {
            head.next.prev = null;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        
        return tmp;
    }
    
    private Item removeTail() {
        if (tail == null) {
            return null;
        }
        
        Item tmp = tail;
        if (tail.prev != null) {
            tail.prev.next = null;
        }
        tail = tail.prev;
        if (tail == null) {
            head = null;
        }
        
        return tmp;
    }
    
    private Item remove(Item item) {
        if (item == head) {
            return removeHead();
        }
        
        if (item == tail) {
            return removeTail();
        }
        
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
            Item t = removeTail();
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
