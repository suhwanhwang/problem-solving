// https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = left;
        for (int i = 0; i < 32; ++i) {
            int num = right & (~(1<<i));
            if (num >= left) {
                ans &= num;
            }
        }
        return ans;
    }
}
