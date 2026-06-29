class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2)
            return n;
        int answer = 2;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;
                // Normalize sign
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }
                // Vertical line
                if (dx == 0) {
                    dy = 1;
                }
                // Horizontal line
                if (dy == 0) {
                    dx = 1;
                }
                String key = dy + "/" + dx;
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);
                max = Math.max(max, count);
            }
            answer = Math.max(answer, max + 1);
        }
        return answer;
    }
    private int gcd(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }
}