class Solution {
    public int minDeletions(String s) {
        int[] counts = new int[26];
        
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        
        Arrays.sort(counts);
        int num = 0;
        for (int i = counts.length - 2; i >= 0; --i) {
            if (counts[i] == 0) {
                break;
            }
            
            if (counts[i] >= counts[i + 1]) {
                int diff  = 0;
                if (counts[i + 1] == 0) {
                    diff = counts[i];
                } else {
                    diff = (counts[i] - counts[i + 1]) + 1;
                }
                num += diff;
                counts[i] -= diff;
            }
        }
        
        return num;
    }
}
