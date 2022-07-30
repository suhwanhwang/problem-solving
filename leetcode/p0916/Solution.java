class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] w2MapTotal = new int[26];
        for(String w2 : words2) {
            int[] m = getCharMap(w2);
            for (int i = 0; i < 26; ++i) {
                w2MapTotal[i] = Math.max(w2MapTotal[i], m[i]);
            }
        }
        
        for(String w1 : words1) {
            int[] w1Map = getCharMap(w1);
            if (isSubset(w1Map, w2MapTotal)) {
                    ans.add(w1);
            }
        }
        return ans;
    }
    
    private boolean isSubset(int[] m1, int[] m2) {
        for (int i = 0; i < m1.length; ++i) {
            if (m1[i] < m2[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int[] getCharMap(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}
