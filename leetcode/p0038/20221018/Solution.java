class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for (int i = 2; i <= n; ++i) {
            s = getSay(s);            
        }
        return s;
    }
    
    private String getSay(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (prev == cur) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev);
                prev = cur;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}
