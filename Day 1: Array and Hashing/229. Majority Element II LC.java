class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int major1 = -1, major2 = -1, count1 = 0, count2 = 0;
        for(int num:nums)
        {
            if(num == major1)
                count1++;
            else if(num == major2)
                count2++;
            else if(count1 == 0)
            {
                count1 = 1;
                major1 = num;
            }
            else if(count2 == 0)
            {
                count2 = 1;
                major2 = num;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num:nums)
        {
            if(num == major1)
                count1++;
            else if(num == major2)
                count2++;
        }

        List<Integer> majorityElements = new ArrayList<>();
        int n = nums.length;
        if(count1>(n/3))
            majorityElements.add(major1);
        if(count2>(n/3))
            majorityElements.add(major2);

        return majorityElements;
    }
}
