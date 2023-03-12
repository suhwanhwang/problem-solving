class Solution {
    public int tribonacci(int n) {
        int[] t = new int[3];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;

        if (n < 3) {
            return t[n];
        }

        for (int i = 3; i <= n; ++i) {
            int next = t[0] + t[1] + t[2];
            t[0] = t[1];
            t[1] = t[2];
            t[2] = next;
        }
        return t[2];
    }
}
