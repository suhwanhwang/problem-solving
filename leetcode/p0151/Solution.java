// https://leetcode.com/problems/reverse-words-in-a-string
class Solution {
    public String reverseWords(String s) {
        String[] tokens = s.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(int i = tokens.length-1; i >= 0; --i) {
            //System.out.println("[" + tokens[i] + "]");
            if (tokens[i].length() == 0) continue;
            
            if (!isFirst) {
                sb.append(' ');
            } else {
                isFirst = false;
            }
            sb.append(tokens[i]);
        }
        return sb.toString();
    }
}
