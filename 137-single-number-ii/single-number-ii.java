class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int mask;
        for(int i=0; i<32; i++) {
            mask = (1 << i);
            int sum = 0;
            for(int num : nums) {
                if((num & mask) != 0) {
                    sum++;
                }
            }
            if(sum%3 != 0) {
                ans |= mask;
            }
        }
        return ans;
    }
}

//Constant State Machine Solution
// class Solution {
//     public int singleNumber(int[] nums) {
//         int ones = 0;
//         int twos = 0;
//         for (int num : nums) {
//             ones = (ones ^ num) & ~twos;
//             twos = (twos ^ num) & ~ones;
//         }
//         return ones;
//     }
// }