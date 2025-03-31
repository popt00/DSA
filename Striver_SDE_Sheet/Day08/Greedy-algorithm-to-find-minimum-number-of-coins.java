class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int[]dp= new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.sort(coins);
        dp[0]=0;
        int i=0;
        while(i<=sum){
            if(dp[i]!=Integer.MAX_VALUE){
                for(int j=0;j<coins.length && i+coins[j]<=sum;j++){
                    dp[i+coins[j]]=Math.min(dp[i+coins[j]], dp[i]+1);
                }
            }
            i++;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[sum]!=Integer.MAX_VALUE?dp[sum]:-1;
    }
}
