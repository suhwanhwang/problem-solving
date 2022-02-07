class Solution {
    public char findTheDifference(String s, String t) {
        int[] sMap = getMap(s);
        int[] tMap = getMap(t);
        for(int i = 0; i < sMap.length; ++i) {
            if (sMap[i] != tMap[i]) {
                return (char)(i + 'a');
            }
        }
        return ' ';
    }
    
    private int[] getMap(String s) {
        int[] map = new int[26];
        for(char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}
