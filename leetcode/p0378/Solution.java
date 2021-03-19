/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-10^9 <= matrix[i][j] <= -10^9
All the rows and columns of matrix are guaranteed to be sorted in non-degreasing order.
1 <= k <= n^2

*/
class Solution {
    public int kthSmallest_nlogn(int[][] matrix, int k) {
        int[] flatten = new int[matrix.length * matrix[0].length];
        
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                flatten[i * matrix[0].length + j] = matrix[i][j];
            }
        }
        Arrays.sort(flatten);
        return flatten[k - 1];
    }
    
    static class Item {
        int row;
        int col;
        int val;
        public Item(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Item> pq = new PriorityQueue<>((item1, item2) -> {
            return item1.val - item2.val;
        });
        
        for (int i = 0; i < matrix.length; ++i){
            pq.offer(new Item(i, 0, matrix[i][0]));
        }
        
        for (int i = 0; i < k - 1; ++i) {
            Item cur = pq.poll();
            
            if (cur.col == matrix[cur.row].length - 1) {
                continue;
            }
            pq.offer(new Item(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        }
        return pq.peek().val;
    }
}
