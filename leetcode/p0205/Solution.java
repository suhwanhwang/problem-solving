/*
https://leetcode.com/problems/isomorphic-strings/
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return convertInt(s).equals(convertInt(t));
    }
    
    private String convertInt(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                char converted = (char)('a' + map.size());
                map.put(c, converted);
                sb.append(converted);
            }
        }
        return sb.toString();
    }
}
