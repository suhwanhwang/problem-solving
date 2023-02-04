class Solution {
    /*

    ab
    eibac
b   ^
c   ^

e1

a1
b1

    */
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        for (char c : s1.toCharArray()) {
            map1[c - 'a']++;
        }


        for (int i = 0; i <= s2.length() - s1.length(); ++i) {
            int[] map2 = new int[26];
            for (int j = i; j < i + s1.length(); ++j) {
                map2[s2.charAt(j) - 'a']++;
            }
            if (compare(map1, map2) == 0) {
                return true;
            }
        }
        return false;

        /*
        int begin = 0;
        int cur = 0;
        while(begin <= s2.length() - s1.length()) {

            while (cur < s2.length()) {
                map2[s2.charAt() - 'a']++;
                int comp = comare(map1, map2);
                if (comp == 0) {
                    return true;
                } else if (comp < 0) {
                    break;
                } else {
                    cur++;
                }
            }
            while (begin < s2.length() &&compare(map1, map2) < 0) {
                map2[s2.charAt(begin) - 'a']--;
                begin++;
            }
        }
        return false;
        */
    }

    private int compare(int[] m1, int[] m2) {
        for (int i = 0; i < m1.length; ++i) {
            if (m1[i] - m2[i] == 0) {
                continue;
            }

            return (m1[i] - m2[i] > 0 ? 1 : -1);
        }
        return 0;
    }
}
