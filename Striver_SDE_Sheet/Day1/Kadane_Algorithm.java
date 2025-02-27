class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int curSum=nums[0];
        for(int i=1;i<nums.length;i++){
            int x= nums[i];
            maxSum=Math.max(maxSum, curSum);
            curSum+=x;
            if(curSum<x)curSum=x;
        }
        maxSum=Math.max(maxSum, curSum);
        return maxSum;
    }
}
