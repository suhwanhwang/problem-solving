class Solution {
    public double myPow(double x, int n) {
        return helper(x, n);
    }

    private double helper(double x, long n) {
        //return Math.pow(x, n);
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            return helper(1/x, -n);
        }

        if (n % 2 == 0) {
            double p = helper(x, n / 2);
            return p * p;
        } else {
            return x * helper(x, n - 1);
        }
    }
}
