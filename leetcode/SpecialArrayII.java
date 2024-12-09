//https://leetcode.com/problems/special-array-ii/description/
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] dp = new int[nums.length];
        int st=0;
        dp[0]=0;
        for(int i=1;i<nums.length;i++){
            dp[i]=dp[i-1];
            if((nums[i]&1)==(nums[i-1]&1))dp[i]++;
        }
        boolean[] ans= new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]= dp[queries[i][0]]==dp[queries[i][1]];
        }
        return ans;
    }
}
