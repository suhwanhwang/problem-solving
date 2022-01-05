class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return ans;
    }
    
    private void helper(String s, int index, List<String> pal) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(pal));
            return;
        }
        
        for(int i = index; i < s.length(); ++i) {
            if (isPal(s, index, i)) {
                pal.add(s.substring(index, i + 1));
                helper(s, i + 1, pal);
                pal.remove(pal.size() - 1);
            }
        }
    }
    private boolean isPal(String s, int l, int r) {
        
        for (int i = 0; i <= (r - l)/2; ++i) {
            if (s.charAt(l + i) != s.charAt(r - i)) {
                return false;
            }
        }
        return true;
    }
}
