/*
https://leetcode.com/problems/word-ladder/

Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 

Constraints:

1 <= beginWord.length <= 100
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.

*/
class Solution {
    private boolean canTransform(String w0, String w1) {
        if (w0.length() != w1.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < w0.length(); ++i) {
            if (w0.charAt(i) == w1.charAt(i)) {
                continue;
            }
            count++;
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
    
    private static final int INF = 987654321;
    private int bfs(List<List<Integer>> adj, int beginIndex, int endIndex) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, INF);
        
        q.offer(beginIndex);
        dist[beginIndex] = 0;
        visited[beginIndex] = true;
            
        while(!q.isEmpty()) {
            Integer index = q.poll();
            
            for (Integer i : adj.get(index)) {
                if (!visited[i]) {
                    q.offer(i);
                    dist[i] = dist[index] + 1;
                    visited[i] = true;
                }    
            }
        }
        
        return dist[endIndex];
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> fullList = new ArrayList<>(wordList);
        fullList.add(beginWord); // last index is beginWord
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < fullList.size(); ++i) {
            adj.add(new ArrayList<>());
        }
        
        
        for (int i = 0; i < fullList.size() - 1; ++i) {
            for (int j = i + 1; j < fullList.size(); ++j) {
                if (canTransform(fullList.get(i), fullList.get(j))) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }    
        
        int beginIndex = fullList.size() - 1;
        int endIndex = -1;
        for (int i = 0; i < fullList.size() - 1; ++i) {
            if (endWord.equals(fullList.get(i))) {
                endIndex = i;
                break;
            }
        }
        
        if (endIndex == -1) {
            return 0;
        }
        
        int dist = bfs(adj, beginIndex, endIndex);
        return dist!= INF ? dist + 1 : 0;
    }
}
