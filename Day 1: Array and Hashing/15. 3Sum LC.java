class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length, sum;
        
        for(int i=0; i<(n-2); i++)
        {
            int left = i+1, right=n-1;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            while(left<right)
            {
                sum = (nums[i]+nums[left]+nums[right]);
                if(sum<0)
                    left++;
                else if(sum>0)
                    right--;
                else
                {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(left<right && nums[left]==nums[left-1])
                        left++;
                }
            }
        }

        return triplets;

    }
}
