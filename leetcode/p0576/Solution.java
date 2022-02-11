class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (char c : s1.toCharArray()) {
            s1Map[c - 'a']++;
        }
        int start = 0;
        for (int i = 0; i < s2.length(); ++i) {
            char c = s2.charAt(i);
            s2Map[c - 'a']++;
            if (i - start + 1 < s1.length()) {
                continue;
            }
            
            if (i - start + 1 > s1.length()) {
                s2Map[s2.charAt(start) - 'a']--;
                start++;
            } 
            if (Arrays.equals(s1Map, s2Map)) {
                return true;
            }
        }
        return false;
    }
}
