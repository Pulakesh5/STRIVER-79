class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        // 1 4 5 3 2
        int pos = 0;
        for(int i=nums.size()-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                pos=i;
                break;
            }
        }
        for(int i=nums.size()-1;i>=pos && pos>0 ; i--){
            if(nums[i]>nums[pos-1]){
                swap(nums[i],nums[pos-1]);
                break;
            }
        }
         reverse(nums.begin()+pos,nums.end());
    }
};
