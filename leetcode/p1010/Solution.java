class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        for (int num : time) {
            map[num%60]++;
        }
        
        int numPairs = map[0] * (map[0] - 1) / 2 + map[30] * (map[30] - 1) / 2;
        
        for (int i = 1; i < 30; ++i) {
            numPairs += map[i] * map[60 - i];
        }
        return numPairs;
    }
}
