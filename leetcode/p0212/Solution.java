/*
https://leetcode.com/problems/word-search-ii/

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
*/
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        
        for (String s : words) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            
            for (int i = 0; i < board.length; ++i) {
                boolean isFound = false;
                for (int j = 0; j < board[0].length; ++j) {
                    if (isExist(board, s, i, j, 0, visited)) {
                        ans.add(s);
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
            }
        }
        return ans;
    }
    
    private static final int[][] dir = {
        {-1,0},
        {0,1},
        {1,0},
        {0,-1}
    };
    
    private boolean isExist(char[][] board, String word, int r, int c, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        
        if (visited[r][c]) {
            return false;
        }
        
        if (board[r][c] != word.charAt(index)) {
            return false;
        }
        
        visited[r][c] = true;
        
        for (int i = 0; i < dir.length; ++i) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if (isExist(board, word, nr, nc, index + 1, visited)) {
                return true;
            }
        }
        
        visited[r][c] = false;
        return false;
    }
}
