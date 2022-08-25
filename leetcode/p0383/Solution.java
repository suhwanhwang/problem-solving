class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomMap = getMap(ransomNote);
        int[] magazineMap = getMap(magazine);
        
        for (int i = 0; i < 26; ++i) {
            if (ransomMap[i] > magazineMap[i]) {
                return false;
            }
        }
        return true;
    }
    private int[] getMap(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}
