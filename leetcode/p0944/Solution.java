class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); ++i) {
            if (!isOrdered(strs, i)) {
                count++;
            }
        }
        return count;
    }
    private boolean isOrdered(String[] strs, int col) {
        char prev = strs[0].charAt(col);
        for (int i = 1; i < strs.length; ++i) {
            char cur = strs[i].charAt(col);
            if (cur - prev < 0) {
                return false;
            }
            prev = cur;
        }
        return true;
    }
}
