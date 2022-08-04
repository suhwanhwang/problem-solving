class Solution {
    public int mirrorReflection(int p, int q) {
        int gcd = gcd(p, q);
        int lcd = p * q / gcd;
        
        int x = lcd / gcd;
        int y = lcd * q / p / gcd;
        
        if (y % 2 == 0) {
            return x % 2 == 0 ? 0 : -1;
        } else {
            return x % 2 == 0 ? 2 : 1;
        }
    }
    
    private int gcd(int a, int b) {
        return (a == 0) ? b : gcd(b % a, a);
    }
}
