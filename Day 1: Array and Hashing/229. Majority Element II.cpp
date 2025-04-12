class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int c1=0,c2=0,maj_ele1=INT_MIN,maj_ele2=INT_MIN;
        int n=nums.size();
        for(int i=0;i<nums.size();i++){
            if(c1==0 and maj_ele2!=nums[i]){
                maj_ele1=nums[i];
                c1=1;
            }
            else if( maj_ele1 == nums[i]) c1++;
            else if(c2==0 and maj_ele1!=nums[i]){
                maj_ele2=nums[i];
                c2=1;
            }
            else if(maj_ele2 == nums[i]) c2++;
            else {
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int i=0;i<nums.size();i++){
            if(maj_ele1 == nums[i]) c1++;
            else if(maj_ele2 == nums[i]) c2++;
        }
        vector<int> ans;
        if(c1 > n/3) ans.push_back(maj_ele1);
        if(c2 > n/3) ans.push_back(maj_ele2);
        return ans;
    }
};
