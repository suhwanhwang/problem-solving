class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int nthMagicalNumber_bt(int n, int a, int b) {
        int count = 0;
        
        for (int i = 1; ; ++i) {
            if (i % a == 0 || i % b == 0) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }
    }
    
    public int nthMagicalNumber(int n, int a, int b) {
        int gcd = gcd(a, b);
        int lcm = (int)(((long)a * (long)b) / gcd);
        long left = Math.min(a, b);
        long right = ((long)n * (long)Math.max(a,b)) + 1;
        
        while(left < right) {
            long mid = (left + right) >>> 1;
            long count = mid / a + mid / b - mid / lcm;
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int)(left % MOD);
    }
    
    private int gcd(int a, int b) {
	    return b != 0 ? gcd(b, a % b) : a;
    }
}
