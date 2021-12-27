class Solution {
    public int findComplement(int num) {
        for (int i = 1; i < 32; ++i) {
            int comp = (1<<i) - 1;
            if (num <= comp) {
                return comp - num;
            }
        }
        return 0;
        
    }
}
