class Solution {
    public boolean repeatedSubstringPattern(String s) {
        boolean isOK = false;
        for (int i = 1; i <= s.length() / 2; ++i) {
            if (s.length() % i != 0) {
                continue;
            }
            
            isOK = true;
            String sub = s.substring(0, i);
            
            for (int j = 1; j < s.length() / i; ++j) {
                String cur = s.substring(j * i, j * i + i);
                if (!sub.equals(cur)) {
                    isOK = false;
                    break;
                }
            }
            if (isOK) {
                return true;
            }
        }
        return false;
    }
}
