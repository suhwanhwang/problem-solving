/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(grid, 0, 0, n);
    }

    private Node helper(int[][]grid, int left, int top, int len) {
        if (len == 1) {
            return new Node(grid[top][left] == 1, true);
        }

        int val = grid[top][left];
        boolean isSame = true;
        for (int i = left; i < left + len; ++i) {
            for (int j = top; j < top + len; ++j) {
                if (val != grid[j][i]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }

        if (isSame) {
            return new Node(val == 1, true);
        }

        Node node = new Node(val == 1, false);
        int half = len/2;
        node.topLeft = helper(grid, left, top, half);
        node.topRight = helper(grid, left+half, top, half);
        node.bottomLeft = helper(grid, left, top + half, half);
        node.bottomRight = helper(grid, left + half, top + half, half);
        return node;
    }
}
