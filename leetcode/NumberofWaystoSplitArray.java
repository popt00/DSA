//https://leetcode.com/problems/number-of-ways-to-split-array/description/
class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0,currentSum=0;
        for(int x:nums)sum+=x;
        int count=0;
        for(int i=0;i+1<nums.length;i++){
            int x=nums[i];
            currentSum+=x;
            sum-=x;
            if(currentSum>=sum)count++;
        }
        return count;
    }
}
