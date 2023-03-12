class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) == Math.abs(b - x)) {
                return a - b;
            }
            return Math.abs(a - x) - Math.abs(b - x);
        });
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(list.get(i));
        }
        Collections.sort(ans);
        return ans;
    }
}
