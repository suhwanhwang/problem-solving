class Solution {
    /*
    public List<String> findWords(char[][] board, String[] words) {
        List<String> allWords = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;
        
        for (String word : words) {
            boolean isFound = false;
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    boolean[][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    if (dfs(board, word, i, j, visited)) {
                        allWords.add(word);
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
            }
        }
        return allWords;
    }
    
    private static final int[][] DIR = {
        {0,1},{1,0},{0,-1},{-1,0}
    };
    
    private boolean dfs(char[][]board, String target, int row, int col, boolean[][] visited) {
        if (board[row][col] != target.charAt(0)) {
            return false;
        }

        if (target.length() == 1) {
            return true;
        }
        
        for (int[] d : DIR) {
            int nr = row + d[0];
            int nc = col + d[1];
            
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            
            visited[nr][nc] = true;
            if (dfs(board, target.substring(1), nr, nc, visited)) {
                return true;
            }
            visited[nr][nc] = false;
        }
        return false;
    }
    */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> findWords = new ArrayList<>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, i, j, visited, rootNode, 0);
            }
        }

        for (String word : words) {
            if (isExist(rootNode, word)) {
                findWords.add(word);
            }
        }

        return findWords;
    }

    private static final int[][] DIR = {
        {0,1},{1,0},{0,-1},{-1,0}
    };
    private static final int MAX_WORD_LEN = 10;
    private void dfs(char[][] board, int row, int col, boolean[][] visited, TrieNode node, int len) {
        if (len >= MAX_WORD_LEN) {
            return;
        }

        visited[row][col] = true;
        if (node.child[board[row][col] - 'a'] == null) {
            node.child[board[row][col] - 'a'] = new TrieNode();
        }

        for (int[] d : DIR) {
            int nr = row + d[0];
            int nc = col + d[1];
            
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            
            dfs(board, nr, nc, visited, node.child[board[row][col] - 'a'], len + 1);
        }
        
        visited[row][col] = false; 
    }

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
    }

    private TrieNode rootNode = new TrieNode();
    private void addNode(TrieNode root, String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
            }
            cur = cur.child[c - 'a'];
        }
    }

    private boolean isExist(TrieNode root, String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return false;
            }
            cur = cur.child[c - 'a'];
        }
        return true;
    }
}
