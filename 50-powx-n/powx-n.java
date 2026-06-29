//USING RECURSIVE
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
    public double fastPow(double x, long n) {
        if(n == 0) return 1;
        double half = fastPow(x, n/2);
        if(n%2 == 0) {
            return half * half;
        }else {
            return half * half * x;
        }
    }
}
//USING ITERATIVE
// class Solution {
//     public int mySqrt(int x) {
//         if (x < 2)
//             return x;
//         int left = 1;
//         int right = x;
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             long square = (long) mid * mid;
//             if (square == x)
//                 return mid;
//             if (square < x) {
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }
//         return right;
//     }
// }