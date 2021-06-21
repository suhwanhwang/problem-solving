/*
https://leetcode.com/problems/pascals-triangle/solution/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30

*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; ++i) {
            ans.add(helper(i));
        }
        return ans;
    }
    
    private List<Integer> helper(int n) {
        if (n == 1) return Arrays.asList(1);
        
        List<Integer> prev = helper(n-1);
        List<Integer> cur = new ArrayList<>();
        
        cur.add(1);
        for (int i = 1; i < prev.size(); ++i) {
            cur.add(prev.get(i-1)+prev.get(i));
        }
        cur.add(1);
        return cur;
    }
}
