class SmallestInfiniteSet {
    private int smallest = 1;
    private TreeSet<Integer> treeSet = new TreeSet<>();

    public SmallestInfiniteSet() {
    }
    
    public int popSmallest() {
        int num;
        if (treeSet.isEmpty()) {
            num = smallest;
            smallest++;
        } else {
            num = treeSet.first();
            treeSet.remove(num);
        }
        return num;
    }
    
    public void addBack(int num) {
        if (smallest <= num) {
            return;
        }

        treeSet.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
