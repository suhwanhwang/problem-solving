class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        String convertedPattern = convert(pattern);
        for (String word : words) {
            if (convertedPattern.equals(convert(word))) {
                ans.add(word);
            }
        }
        return ans;
    }
    
    private String convert(String word) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, (char)('a' + map.size()));
            }
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}
