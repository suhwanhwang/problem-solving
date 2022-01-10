class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(carry == 1 || i >= 0 || j >= 0) {
            int ia = (i >= 0 ? a.charAt(i) - '0' : 0);
            int ib = (j >= 0 ? b.charAt(j) - '0' : 0);
            int res = ia + ib + carry;
            carry = (res >> 1);
            sb.insert(0, (res & 0x1));
            i--; j--;
        }
        return sb.toString();
    }
}
