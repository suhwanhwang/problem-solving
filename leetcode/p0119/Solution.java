class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());
        lists.get(0).add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            List<Integer> prev = lists.get((i - 1) % 2);
            List<Integer> cur = lists.get(i % 2);
            cur.clear();
            cur.add(1);
            for (int j = 0; j < prev.size() - 1; ++j) {
                cur.add(prev.get(j) + prev.get(j + 1));
            }
            cur.add(1);
        }
        return lists.get(rowIndex % 2);
    }
}
