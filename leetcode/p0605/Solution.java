class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 1) continue;
            
            int prev = (i > 0) ? flowerbed[i - 1] : 0;
            int next = (i < flowerbed.length - 1) ? flowerbed[i + 1] : 0;
            if (prev == 0 && next == 0) {
                flowerbed[i] = 1;
                max++;
            }
        }
        
        return n <= max;
    }
}
