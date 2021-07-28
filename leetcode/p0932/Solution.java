/*
https://leetcode.com/problems/beautiful-array/
*/
class Solution {
    public int[] beautifulArray(int n) {
        int[] ans = helper(n);
        return ans;
    }
    private int[] helper(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        
        int[] even = helper(n/2);
        int[] odd = helper((n+1)/2);
        int[] ans = new int[n];
        
        for (int i = 0; i < odd.length; ++i) {
            ans[i] = odd[i] * 2 - 1;
        }
        for (int i = odd.length; i < n; ++i) {
            ans[i] = even[i - odd.length] * 2;
        }
        
        return ans;
    }
}
