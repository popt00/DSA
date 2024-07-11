/*
* https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/description/
* as we want sum of pair to be in multiple of 24 we will use modular of all numbers and save total of each
* after that (1,23) (2,22) i.e multiply etc.. (0,0) and (12,12) nC2
*/
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[]dp=new int[24];
        for(int x:hours)dp[x%24]++;
        long ans=0;
        for(int i=1;i<12;i++){
            ans= ans+(1l*dp[i]*dp[24-i]);
        }
        ans= ans+(1l*dp[12]*(dp[12]-1))/2;
        ans= ans+(1l*dp[0]*(dp[0]-1))/2;
        return ans;
    }
}
