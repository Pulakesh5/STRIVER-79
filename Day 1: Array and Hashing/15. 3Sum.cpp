class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        set<vector<int>> st;
        vector<vector<int>> ans;
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size();i++){
            int sum=-1*nums[i];
            int l=i+1;
            int h=nums.size()-1;
            while(l<h){ //2-sum
                int l_sum=nums[l]+nums[h];
                if(sum==l_sum){
                    if(st.find({nums[i],nums[l],nums[h]})==st.end()){
                        ans.push_back({nums[i],nums[l],nums[h]});
                        st.insert({nums[i],nums[l],nums[h]});
                    }
                    l++;
                    h--;
                }
                else if(sum > l_sum){
                    l++;
                }
                else{
                    h--;
                }
            }
        }
        return ans;
    }
};
