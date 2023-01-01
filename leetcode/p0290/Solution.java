class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] tokens = s.split(" ");
        if (tokens.length != pattern.length()) {
            return false;
        }
        
        Map<String, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < tokens.length; ++i) {
            Character c = map.get(tokens[i]);
            if (c != null) {
                if (!c.equals(pattern.charAt(i))) {
                    return false;
                }
            } else {
                char temp = pattern.charAt(i);
                if (set.contains(temp)) {
                    return false;
                }
                map.put(tokens[i], temp);
                set.add(temp);
            }
        }
        return true;
    }
}
