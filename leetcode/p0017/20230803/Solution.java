class Solution {
    private List<String> total = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        total.clear();

        dfs(digits, 0, "");
        return total;
    }

    private final String[] dial = {
        "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };
    private void dfs(String digits, int index, String s) {
        if (index == digits.length()) {
            if (s.length() > 0)
                total.add(s);
            return;
        }

        for (char c : dial[digits.charAt(index) - '1'].toCharArray()) {
            s += c;
            dfs(digits, index + 1, s);
            s = s.substring(0, s.length() - 1);
        }
    }
}
