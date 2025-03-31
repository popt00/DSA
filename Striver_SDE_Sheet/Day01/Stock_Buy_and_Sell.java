class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff=0, minTillNow=prices[0];
        for(int x:prices){
            maxDiff=Math.max(maxDiff,x-minTillNow);
            minTillNow=Math.min(x,minTillNow);
        }
        return maxDiff;
    }
}
