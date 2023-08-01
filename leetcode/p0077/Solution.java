class Solution {
    private List<List<Integer>> total = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        total.clear();
        dfs(n, k, new ArrayList<>());
        return total;
    }

    private void dfs(int n, int k, List<Integer> list) {
        if (list.size() == k) {
            total.add(new ArrayList<>(list));
            return;
        }

        int last = list.isEmpty() ? 0 : list.get(list.size() - 1);
        for (int i = last + 1; i <= n; ++i) {
            list.add(i);
            dfs(n, k, list);
            list.remove(list.size() - 1);
        }
    }
}
