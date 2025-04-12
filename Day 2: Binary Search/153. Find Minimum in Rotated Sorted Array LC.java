class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int mid;
        while(left<right)
        {
            mid = (left+right)/2;
            if(nums[left]<nums[right])
                return nums[left];

            if(nums[left]<=nums[mid])
                left = mid+1;
            else 
                right = mid; 
        }
        return nums[left];
    }
}
