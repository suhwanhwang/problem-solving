class Solution {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int cur = 0;
        for (int g : gain) {
            cur += g;
            highest = Math.max(highest, cur);
        }
        return highest;
    }
}
