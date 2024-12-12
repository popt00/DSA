//https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=1,i=0,j=0;
        while(j<nums.length){
            // -k to +k so ar[i]+k....ar[j]-k
            // ar[i]+k >= ar[j]-k; given: ar[i]<=ar[j] then it is in range
            if(nums[i]+k>=nums[j]-k){
                ans=Math.max(j-i+1,ans);
                j++;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}
