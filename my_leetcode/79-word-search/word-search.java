class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,
                        String word,
                        int row,
                        int col,
                        int index) {
        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length)
            return false;
        // Character doesn't match
        if (board[row][col] != word.charAt(index))
            return false;
        // Entire word matched
        if (index == word.length() - 1)
            return true;
        // Mark as visited
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found =
                dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row, col + 1, index + 1) ||
                dfs(board, word, row, col - 1, index + 1);
        // Backtrack
        board[row][col] = temp;
        return found;
    }
}