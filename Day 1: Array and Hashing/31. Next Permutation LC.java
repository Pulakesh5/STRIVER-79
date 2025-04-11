class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int prev = -1;
        for(int i=n-1; i>=0; i--)
        {
            if(nums[i]<prev)
            {
                int lastIndex = n-1;
                while(lastIndex>i && nums[i]>=nums[lastIndex])
                    lastIndex--;
                int tmp = nums[lastIndex];
                nums[lastIndex] = nums[i];
                nums[i] = tmp;
                Arrays.sort(nums, i+1, n);
                return;
            }
            prev = nums[i];
        }
        int left=0, right=n-1, tmp;
        while(left<right)
        {
            tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            left++;
            right--;
        }
    }
}
