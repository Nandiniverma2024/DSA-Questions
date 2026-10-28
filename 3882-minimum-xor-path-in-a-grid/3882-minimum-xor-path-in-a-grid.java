
class Solution {
    boolean[][][] visited;
    int ans = Integer.MAX_VALUE;

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        visited = new boolean[n][m][1024];

        solve(grid, 0, 0, 0, n, m);

        return ans;
    }

    void solve(int[][] grid, int i, int j, int xor, int n, int m) {
        xor ^= grid[i][j];

        if (ans == 0) return;

        if (visited[i][j][xor]) return;
        visited[i][j][xor] = true;

        if (i == n - 1 && j == m - 1) {
            ans = Math.min(ans, xor);
            return;
        }

        if (i + 1 < n) {
            solve(grid, i + 1, j, xor, n, m);
        }

        if (j + 1 < m) {
            solve(grid, i, j + 1, xor, n, m);
        }
    }
}
