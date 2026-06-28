class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }
    private void dfs(char[][] board,
                     int row,
                     int col,
                     TrieNode node) {
        if (row < 0 || col < 0 ||
            row >= board.length ||
            col >= board[0].length)
            return;
        char ch = board[row][col];
        if (ch == '#')
            return;
        TrieNode next = node.children[ch - 'a'];
        if (next == null)
            return;
        if (next.word != null) {
            result.add(next.word);
            next.word = null;     // avoid duplicates
        }
        board[row][col] = '#';
        dfs(board, row + 1, col, next);
        dfs(board, row - 1, col, next);
        dfs(board, row, col + 1, next);
        dfs(board, row, col - 1, next);
        board[row][col] = ch;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }
            curr.word = word;
        }
        return root;
    }
}