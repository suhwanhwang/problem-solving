class Solution {
    private static final int MOD = (int)1e9 + 7;
    
    public int concatenatedBinary(int n) {
        long result = 0;
        for (int i = 1; i<= n; ++i) {
            int shift = getMsb(i);
            result <<= shift;
            result += i;
            result %= MOD;
        }
        return (int)result;
    }
    
    private int getMsb(int n) {
        for (int i = 31; i >= 0; --i) {
            if(((1<<i) & n) != 0) {
                return i + 1;
            }
        }
        return 1;
    }
}
