class SummaryRanges {
    private final Set<Integer> treeSet = new TreeSet<>();

    public SummaryRanges() {
        
    }
    
    public void addNum(int value) {
        treeSet.add(value);
    }
    
    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();

        int prev = -1;
        int start = -1;
        for(int num : treeSet) {
            if (prev == -1) {
                start = num;
            } else if (num > prev + 1) {
                list.add(new int[]{start, prev});
                start = num;
            }
            prev = num;
        }
        list.add(new int[]{start, prev});

        // int[][] ans = new int[list.size()][2];
        // for (int i = 0; i < list.size(); ++i) {
        //     ans[i][0] = list.get(i)[0];
        //     ans[i][1] = list.get(i)[1];
        // }
        return list.toArray(new int[list.size()][2]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
