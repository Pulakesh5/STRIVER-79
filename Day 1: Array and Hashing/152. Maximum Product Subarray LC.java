class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], leftProduct = 0, rightProduct = 0;
        int N = nums.length;
        for(int i=0; i<N; i++)
        {
            if(leftProduct == 0)
                leftProduct = nums[i];
            else
                leftProduct *= nums[i];
            
            if(rightProduct == 0)
                rightProduct = nums[N-1-i];
            else
                rightProduct *= nums[N-1-i];
            
            ans = Math.max(ans, leftProduct);
            ans = Math.max(ans, rightProduct);
        }
        return ans;
    }
}
