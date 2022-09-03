class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        numList = new ArrayList<>();
        dfs(n, k, "");
        
        int[] ans = new int[numList.size()];
        for (int i = 0; i < numList.size(); ++i) {
            ans[i] = numList.get(i);
        }
        return ans;
    }
    
    private List<Integer> numList;
    
    private void dfs(int n, int k, String num) {
        if (num.length() == n) {
            numList.add(
            Integer.parseInt(num));
            return;
        }
        
        if (num.length() == 0) {
            for (int i = 1; i <= 9; ++i) {
                dfs(n, k, num + i);
            }
        } else {
            int prev = num.charAt(num.length() - 1) - '0';
            int small = prev - k;
            int large = prev + k;
            if (small >= 0) {
                dfs(n, k, num + small);
            }
            if (k != 0 && large < 10) {
                dfs(n, k, num + large);
            }
        }
    }
}
