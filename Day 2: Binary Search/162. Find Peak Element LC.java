class Solution {
    public int findPeakElement(int[] nums) {
        int N = nums.length;
        if(N==1)
            return 0;
        
        if(nums[0]>nums[1])
            return 0;
        if(nums[N-2] < nums[N-1])
            return N-1;

        int left = 1, right = N-2, mid;
        while(left<=right)
        {
            mid = left+(right-left)/2;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1])
                return mid;
            else if(nums[mid]<nums[mid+1])
                left = mid+1;
            else if(nums[mid]<nums[mid-1])
                right = mid-1;
        }
        return -1;
    }
}
