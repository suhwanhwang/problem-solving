class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int diff = 0;
        Set<Character> set = new HashSet<>();
        int start = -1;
        int end = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
                if (start == -1) {
                    start = i;
                } else if (end == -1) {
                    end = i;
                }
            }
            set.add(s.charAt(i));
        }
        return (diff == 2 && s.charAt(start) == goal.charAt(end) && s.charAt(end) == goal.charAt(start)) || (diff == 0 && set.size() < s.length());
    }
}
