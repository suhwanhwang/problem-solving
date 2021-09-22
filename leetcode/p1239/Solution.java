// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, new HashSet<>());
    }
    
    private int helper(List<String> arr, int index, Set<Character> set) {
        if (index >= arr.size()) {
            return set.size();
        }
        
        int max = 0;
        String cur = arr.get(index);
        if (isUnique(cur) && !isContains(set, cur)) {
            for(char c : cur.toCharArray()) {
                set.add(c);
            }
            max = helper(arr, index+1, set);
            for(char c : cur.toCharArray()) {
                set.remove(c);
            }
        }
        max = Math.max(max, helper(arr, index+1, set));
        
        return max;
    }
    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
    
    private boolean isContains(Set<Character> set, String s) {
        for(char c : s.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
        }
        return false;
    }
}
