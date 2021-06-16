/*
https://leetcode.com/problems/matchsticks-to-square/

You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

 

Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
 

Constraints:

1 <= matchsticks.length <= 15
0 <= matchsticks[i] <= 10^9
*/
class Solution {
    private boolean[] visited;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int squareLen = sum / 4;
        
        Arrays.sort(matchsticks);
        visited = new boolean[matchsticks.length];

        for (int i = matchsticks.length - 1; i >= 0; --i) {
            if (!visited[i]) {
                visited[i] = true;
                if (!dfs(matchsticks, i, squareLen - matchsticks[i])) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int[] m, int index, int sum) {
        if (index < 0 || sum <= 0) return sum == 0;
        
        for (int i = index - 1; i >= 0; --i) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(m, i, sum - m[i])) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
