/*
https://leetcode.com/problems/course-schedule-ii/description/

There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.

*/
class Solution {
    private boolean dfs(List<List<Integer>> adj, int index, boolean[] visited, Stack<Integer> st, Set<Integer> path) {
        if (path.contains(index)) {
            return false;
        }
        
        if (visited[index]) {
            return true;
        }
        
        visited[index] = true;
        path.add(index);
        
        for (int i : adj.get(index)) {
            if (!dfs(adj, i, visited, st, path)) {
                    return false;
            }
        }
        st.push(index);
        path.remove(index);
        return true;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        
                
        for (int i = 0; i < numCourses; ++i) {
            Set<Integer> path = new HashSet<>();
            if (!dfs(adj, i, visited, st, path)) {
                    return new int[0];    
            }
        }
        
        int[] ans = new int[numCourses];
        int index = 0;
        while (!st.isEmpty()) {
            ans[index++] = st.pop();
        }
        
        return ans;
    }
}
