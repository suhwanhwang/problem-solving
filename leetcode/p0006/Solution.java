class Solution {

    /*

r: 3
0   4
1 3 5
2   6

(r - 2) * 2 + 2

r: 4
0123456
0     6
1   5 7
2 4   8 
3     9

r: 5
012345678
0       8
1     7 9
2   6   10
3 5     11
4       12

    */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int w = (numRows - 2) * 2 + 2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; ++i) {

            for (int j = i; j < s.length() ; j += w) {
                if (i == 0 || i == numRows - 1) {
                    sb.append(s.charAt(j));

                } else {
                    sb.append(s.charAt(j));
                    if (j + w - 2 * i < s.length()) {
                        sb.append(s.charAt(j + w - 2 * i));
                    }
                }
            }
        }
        return sb.toString();
    }
}
