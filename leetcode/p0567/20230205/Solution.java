class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] m1 = new int[26];
        int[] m2 = new int[26];

        for (char c : s1.toCharArray()) {
            m1[c - 'a']++;
        }

        int begin = 0;
        for (int i = 0; i < s2.length(); ++i) {
            char c = s2.charAt(i);
            m2[c - 'a']++;

            int len = i - begin + 1;
            if (len < s1.length()) {
                continue;
            }

            if (len > s1.length()) {
                m2[s2.charAt(begin) - 'a']--;
                begin++;
            }
            if (Arrays.equals(m1, m2)) {
                return true;
            }
        }
        return false;
    }
}
