class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1);
        visited[1] = true;
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n * n)
                    return moves;
                for (int dice = 1; dice <= 6 && curr + dice <= n * n; dice++) {
                    int next = curr + dice;
                    int[] pos = getPosition(next, n);
                    int row = pos[0];
                    int col = pos[1];
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    private int[] getPosition(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        int row = n - 1 - r;
        int col;
        if (r % 2 == 0) {
            col = c;
        } else {
            col = n - 1 - c;
        }
        return new int[]{row, col};
    }
}