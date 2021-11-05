class Solution {
    public int arrangeCoins(int n) {
        long sum = 0;
        int i = 1;
        while (sum < n) {
            sum += i; 
            ++i;
        }
        return (sum > n) ? i - 2 : i - 1;
    }
}
