
/*
https://leetcode.com/problems/group-anagrams/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]

*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; ++i) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            List<String> list = map.get(sorted);
            if (list == null) {
                list = new ArrayList<>();
                map.put(sorted, list);
            }
            list.add(strs[i]);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
