//REVERSE THE ENTIRE NUMBER
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int original = x;
        int reverse = 0;
        while (x != 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x /= 10;
        }
        return original == reverse;
    }
}
//OPTIMAL (REVERSE ONLY HALF)
// class Solution {
//     public boolean isPalindrome(int x) {
//         if (x < 0 || (x % 10 == 0 && x != 0))
//             return false;
//         int reversedHalf = 0;
//         while (x > reversedHalf) {
//             reversedHalf = reversedHalf * 10 + x % 10;
//             x /= 10;
//         }
//         return x == reversedHalf ||
//                x == reversedHalf / 10;
//     }
// }