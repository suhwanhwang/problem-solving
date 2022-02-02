class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pMap = new int[26];
        int pLen = p.length();
        for(char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }
        
        List<Integer> ans = new ArrayList<>();
        int[] sMap = new int[26];
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (pLen < i - start + 1) {
                sMap[s.charAt(start) - 'a']--;
                start++;
            }
            sMap[s.charAt(i) - 'a']++;
            if (pLen == i - start + 1 && Arrays.equals(pMap, sMap)) {
                ans.add(start);
            }
        }
        return ans;
    }
}
