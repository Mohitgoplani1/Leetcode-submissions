class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int n = grid.size(), m = grid[0].size();
        int total = n * m;
        k %= total;
        vector<vector<int>> res(n, vector<int>(m));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int p = (i * m + j + k) % total;
                res[p / m][p % m] = grid[i][j];
            }
        }
        return res;
    }
};