// class Solution {
//     public int hammingWeight(int n) {
//         int count = 0;
//         for (int i = 0; i < 32; i++) {
//             if ((n & 1) == 1)
//                 count++;
//             n >>>= 1;
//         }
//         return count;
//     }
// }
//Brian Kernighan's Algorithm
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}