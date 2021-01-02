/*
https://leetcode.com/problems/pascals-triangle/

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        
        ans.add(Arrays.asList(1));
        
        for (int i = 1; i < numRows; ++i) {
            List<Integer> prev = ans.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < prev.size(); ++j) {
                cur.add(prev.get(j-1) + prev.get(j));    
            }
            cur.add(1);
            
            ans.add(cur);
        }
        
        return ans;
    }
}
