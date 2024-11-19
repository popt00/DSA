//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long currSum=0,ans=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
            currSum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()==k)ans=currSum;
        for(int i=k;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            currSum+=nums[i];
            if(map.get(nums[i-k])==1)map.remove(nums[i-k]);
            else map.put(nums[i-k],map.get(nums[i-k])-1);
            currSum-=nums[i-k];
            if(map.size()==k)ans=Math.max(ans,currSum);
        }
        return ans;
    }
}
