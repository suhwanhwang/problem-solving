class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        helper(s,0,new ArrayList<>(),ans);
        return ans;
    }
    private void helper(String s, int index, List<String> palindrome, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(palindrome));
            return;
        }

        for (int i = index + 1; i <= s.length(); ++i) {
            if (!isPalindrome(s, index, i)) {
                continue;
            }
            palindrome.add(s.substring(index, i));
            helper(s, i, palindrome, ans);
            palindrome.remove(palindrome.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {

        for (int i = 0; i < (end - start) / 2; ++i) {
            if (s.charAt(start+i) != s.charAt(end - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
