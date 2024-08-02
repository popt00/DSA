/*
* https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii
* if all ones are together, then it means i to i+ count(num) window has all ones
* that means,in this window, any zero in original array are swapped with ones outside
* to find count of zero faster we are creating dp of counter from 0th index..
* minimum count of zero in window of count(1) is answer.
*/
class Solution {

    public int minSwaps(int[] nums) {
        int len=nums.length, num=0;
        for(int x:nums)if(x==1)num++;
        if(num==0)return 0;

        int[] dp=new int[len];
        if(nums[0]==0)dp[0]=1;
        for(int i=1;i<len;i++){
            dp[i]=dp[i-1];
            if(nums[i]==0)dp[i]++;
        }
        
        int minSwap=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            minSwap=Math.min(minSwap,countZero(i,i+num-1, dp));
        }
        return minSwap;
    }
    
    public int countZero(int i, int j, int[] dp){
        int len=dp.length;
        i=(i+len)%len;
        j=(j+len)%len;
        if(j<i){
            return countZero(i,dp.length-1, dp)+countZero(0,j,dp);
        }
        if(i==0)return dp[j];
        return dp[j]-dp[i-1];
    }
}
