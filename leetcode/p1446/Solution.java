class Solution {
    public int maxPower(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char prev = s.charAt(0);
        int maxLen = 1;
        int cur = 1;
        for(int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (prev == c) {
                cur++;
                maxLen = Math.max(maxLen, cur);
            } else {
                prev = c;
                cur = 1;
            }
        }
        return maxLen;
    }
}
