class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        for (int i = str2.length(); i > 0; --i) {
            String d = str2.substring(0, i);
            if (isDivisor(str1, d) && isDivisor(str2, d)) {
                return d;
            }
        }
        return "";
    }

    private boolean isDivisor(String s, String d) {
        if (s.length() % d.length() != 0) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i += d.length()) {
             if (!d.equals(s.substring(i, i + d.length()))) {
                 return false;
             }
        }
        return true;
    }
}
