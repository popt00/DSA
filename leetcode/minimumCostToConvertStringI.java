/*
* https://leetcode.com/problems/minimum-cost-to-convert-string-i/
* https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
*/
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n=26;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){Arrays.fill(dp[i],Integer.MAX_VALUE);dp[i][i]=0;}
        for(int i=0;i<cost.length;i++){
            int oriIndex=(int)(original[i]-'a'), chaIndex=(int)(changed[i]-'a');
             dp[oriIndex][chaIndex]=Math.min(dp[oriIndex][chaIndex],cost[i]);
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(dp[i][k]!=Integer.MAX_VALUE)
                    for(int j=0;j<n;j++){
                        if(dp[k][j]!=Integer.MAX_VALUE && dp[i][j]>dp[i][k]+dp[k][j]){
                            dp[i][j]=dp[i][k]+dp[k][j];
                        }
                    }
            }
        }
        long ans=0;
        for(int i=0;i<source.length();i++){
            int costSourceToTarget=dp[(int)(source.charAt(i)-'a')][(int)(target.charAt(i)-'a')];
            if(costSourceToTarget==Integer.MAX_VALUE)return -1;
            ans+= 1l*costSourceToTarget;
        }
        return ans;
    }
}
