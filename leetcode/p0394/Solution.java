class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }
        
        char[] chars = s.toCharArray();
        
        int index = 0;
        if (Character.isLetter(chars[index])) {
            while(index < s.length() && Character.isLetter(chars[index])) {
                index++;
            }
            return s.substring(0, index) + decodeString(s.substring(index));
        } else if (Character.isDigit(chars[index])) {
            while(index < s.length() && Character.isDigit(chars[index])) {
                index++;
            }
            int num = Integer.parseInt(s.substring(0, index));
            int lastIndex = findCloseIndex(s, index);
            
            String sub = decodeString(s.substring(index+1, lastIndex));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num; ++i) {
                sb.append(sub);
            }
            return sb.toString() + decodeString(s.substring(lastIndex + 1));
        }
        
        return "";
    }
    
    private int findCloseIndex(String s, int startIndex) {
        char[] chars = s.toCharArray();
        
        int openCount = 0;
        for (int i = startIndex; i < s.length(); ++i) {
            if (chars[i] == '[') {
                openCount++;
            } else if (chars[i] == ']') {
                openCount--;
                if (openCount == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
