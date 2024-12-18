//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
class Solution {
    public int[] finalPrices(int[] prices) {
        int n= prices.length;
        int[] ans=new int[n];
        for(int i =0;i<n;i++){
            ans[i]=prices[i];
            for(int j=i+1;j<n;j++){
                if(prices[j]<=ans[i]){
                    ans[i]-=prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}
