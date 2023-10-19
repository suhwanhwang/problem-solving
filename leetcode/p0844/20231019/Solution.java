class Solution {
    public boolean backspaceCompare(String s, String t) {
        return convert(s).equals(convert(t));
    }
    
    private String convert(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.offerLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : deque) {
            sb.append(c);
        }
        return sb.toString();
    }
}
