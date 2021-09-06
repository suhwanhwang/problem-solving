// https://leetcode.com/problems/slowest-key/
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char c = keysPressed.charAt(0);
        int longest = releaseTimes[0];
        
        for (int i = 1; i < releaseTimes.length; ++i) {
            int delta = releaseTimes[i] - releaseTimes[i - 1];
            if (delta > longest  || (delta == longest && keysPressed.charAt(i) > c)) {
                c = keysPressed.charAt(i);
                longest = delta;
            }
        }
        return c;
    }
}
