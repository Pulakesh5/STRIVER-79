class Solution {
    public int maxSubArray(int[] nums) {
        // classic Kadane's algorithm problem
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int num:nums)
        {
            sum += num;
            maxSum = (sum>maxSum) ? sum : maxSum;
            if(sum<0)
                sum = 0;
        }
        return maxSum;
    }
}
