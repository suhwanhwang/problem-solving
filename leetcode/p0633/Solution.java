// https://leetcode.com/problems/sum-of-square-numbers/
class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Long> squareSet = new HashSet<>();
        for (long i = 0; i * i <= c; ++i) {
            squareSet.add(i * i);
        }
        
        for (long num : squareSet) {
            long target = c - num;
            if (squareSet.contains(target)) {
                return true;
            }
        }
        return false;
    }
}
