class Solution {
    public int compress(char[] chars) {

        char prev = chars[0];
        int count = 1;
        int index = 0;
        for (int i = 1; i < chars.length; ++i) {
            if (prev == chars[i]) {
                count++;
            } else {
                chars[index++] = prev;
                if (count > 1) {
                    char[] num = String.valueOf(count).toCharArray();
                    for (char c : num) {
                        chars[index++] = c;
                    }
                }
                prev = chars[i];
                count = 1;
            }

        }

        chars[index++] = prev;
        if (count > 1) {
            char[] num = String.valueOf(count).toCharArray();
            for(char c : num) {
                chars[index++] = c;
            }
        }
        return index;
    }
}
