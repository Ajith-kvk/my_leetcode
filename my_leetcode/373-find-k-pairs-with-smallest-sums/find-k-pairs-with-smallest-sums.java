class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1,
                                              int[] nums2,
                                              int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]])
                        - (nums1[b[0]] + nums2[b[1]])
        );
        // First element from each row
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (!pq.isEmpty() && k-- > 0) {
            int[] pair = pq.poll();
            int i = pair[0];
            int j = pair[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            // Move to next column in the same row
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }
        }
        return result;
    }
}