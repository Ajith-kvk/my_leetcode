class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftProduct[] = new int[nums.length];
        int rightProduct[] = new int[nums.length];
        for(int i=0, temp=1; i<leftProduct.length; i++) {
            leftProduct[i] = temp;
            temp *= nums[i];
        }
        for(int i=nums.length-1, temp = 1; i>=0; i--) {
            rightProduct[i] = temp;
            temp *= nums[i];
        }
        int result[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}