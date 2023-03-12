class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final int[] mapP = new int[26];
        for (char c : p.toCharArray()) {
            mapP[c - 'a']++;
        }
        final int[] mapS = new int[26];
        final List<Integer> indexes = new ArrayList<>();
        int begin = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            mapS[c - 'a']++;
            int len = i - begin + 1;

            if (len < p.length()) {
                continue;
            }

            if (len > p.length()) {
                mapS[s.charAt(begin) - 'a']--;
                begin++;
            }

            if (Arrays.equals(mapS, mapP)) {
                indexes.add(begin);
            }
        }
        return indexes;
    }
}
