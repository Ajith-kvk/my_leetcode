class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                for (int[] dir : dirs) {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n &&
                        Math.abs(board[r][c]) == 1) {
                        liveNeighbors++;
                    }
                }
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // alive -> dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // dead -> alive
                    }
                }
            }
        }
        // Final conversion
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}