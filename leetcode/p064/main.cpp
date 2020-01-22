class Solution {
    
public:
    /*
    1 3 1
    1 5 1
    4 2 1
    */
    vector<vector<int>> dp;
    
    
    int ps(vector<vector<int>>& grid, int r, int c) {
        if (r==0&&c==0) return grid[0][0];
        if (r < 0 || c < 0) return 987654321;
        int &ans = dp[r][c];
        if (ans!=0) return ans;
        int t = ps(grid, r-1, c);
        int l = ps(grid, r, c-1);
        ans = min(t, l)+grid[r][c];
        return ans;
    }
    
    int minPathSum(vector<vector<int>>& grid) {
        dp=vector<vector<int>>(grid.size(), vector<int>(grid[0].size()));
        return ps(grid, grid.size()-1, grid[0].size()-1);
    }
};
