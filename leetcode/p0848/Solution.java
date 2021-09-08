// https://leetcode.com/problems/shifting-letters/
class Solution {
    public String shiftingLetters_bt(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < shifts.length; ++i) {
            int count = shifts[i];
            for (int j = 0; j <= i; ++j) {
                chars[j] = (char)(((chars[j] - 'a') + count) % 26 + 'a');
            }
            
        }
        return new String(chars);
    }
    
    public String shiftingLetters(String s, int[] shifts) {
        long total = 0;
        for (int i = 0; i < shifts.length; ++i) {
            total += shifts[i];
        }
        
        long[] cumulative = new long[shifts.length];
        cumulative[0] = total;
        for (int i = 1; i < shifts.length; ++i) {
            cumulative[i] = cumulative[i - 1] - shifts[i - 1];
        }
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < shifts.length; ++i) {
            int count = (int)(cumulative[i] % 26);
            chars[i] = (char)(((chars[i] - 'a') + count) % 26 + 'a');
        }
        return new String(chars);
    }
}
