class Solution {
    private List<String> ipList;
    public List<String> restoreIpAddresses(String s) {
        ipList = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return ipList;
    }

    private void helper(String s, int index, List<Integer> ip) {
        if (index >= s.length()) {
            if (ip.size() != 4) return;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ip.size(); ++i) {
                sb.append(ip.get(i));
                if (i < 3) {
                    sb.append('.');
                }
            }
            ipList.add(sb.toString());
            return;
        }

        char c = s.charAt(index);
        
        if (s.length() >= index + 3 && (c == '1' || c == '2' )) {
            int num = Integer.parseInt(s.substring(index, index + 3));
            if (num <= 255) {
                ip.add(num);
                helper(s, index + 3, ip);
                ip.remove(ip.size() - 1);
            }
        } 
        
        if (s.length() >= index + 2 && c != '0') {
            int num = Integer.parseInt(s.substring(index, index + 2));
            ip.add(num);
            helper(s, index + 2, ip);
            ip.remove(ip.size() - 1);
        }

        ip.add(c - '0');
        helper(s, index + 1, ip);
        ip.remove(ip.size() - 1);
    }
}
