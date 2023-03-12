class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; ++i) {
            String prev = words[i - 1];
            String cur = words[i];
            int prevLen = prev.length();
            int curLen = cur.length();
            int lim = Math.min(prevLen, curLen);
            boolean isDiff = false;
            for(int j = 0; j < lim; ++j) {
                char c1 = prev.charAt(j);
                char c2 = cur.charAt(j);
                if (c1 != c2) {
                    if ((map[c1 - 'a'] - map[c2 - 'a']) > 0) {
                        return false;
                    }
                    isDiff = true;
                    break;
                }
            }
            if (!isDiff && prevLen - curLen > 0) {
                return false;
            }
        }
        return true;
    }
}
