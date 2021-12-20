class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        int minDiff = Math.abs(arr[0] - arr[1]);
        for (int i = 1; i < arr.length; ++i) {
            minDiff = Math.min(minDiff, Math.abs(arr[i - 1] - arr[i]));
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; ++i) {
            if (Math.abs(arr[i - 1] - arr[i]) == minDiff) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }
}
