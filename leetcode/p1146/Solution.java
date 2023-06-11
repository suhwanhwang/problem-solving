class SnapshotArray {
    private int nextId = 0;
    private List<TreeMap<Integer, Integer>> array = new ArrayList<>();

    public SnapshotArray(int length) {
        for (int i = 0; i < length; ++i) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0);
            array.add(map);
        }    
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = array.get(index);
        map.put(nextId, val);
    }
    
    public int snap() {
        int id = nextId;
        nextId += 1;
        return id;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = array.get(index);
        return map.get(map.floorKey(snap_id));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
