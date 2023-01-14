class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int[] map = new int[26];
        int curNum = 0;
        for (int i = 0; i < s1.length(); ++i) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            int num1 = map[c1 - 'a'];
            int num2 = map[c2 - 'a'];
            if (num1 == 0 && num2 == 0) {
                curNum++;
                map[c1 - 'a'] = curNum;
                map[c2 - 'a'] = curNum;
            } else if (num1 == 0 || num2 == 0) {
                int num = Math.max(num1, num2);
                map[c1 - 'a'] = num;
                map[c2 - 'a'] = num;
            } else {
                for (int j = 0; j < map.length; ++j) {
                    if (map[j] == Math.min(num1, num2)) {
                        map[j] = Math.max(num1, num2);
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for (char c : baseStr.toCharArray()) {
            int num = map[c - 'a'];
            if (num == 0) {
                sb.append(c);
                continue;
            }
            for (int i = 0; i < map.length; ++i) {
                if (map[i] == num) {
                    sb.append((char)('a' + i));
                    break;
                }
            }
        }

        return sb.toString();
    }
}
