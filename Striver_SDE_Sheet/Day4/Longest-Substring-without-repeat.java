class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans= 0;
        int [] dp = new int[100];
        Arrays.fill(dp,-1);
        for(int i=0;i<s.length();i++){
            int val= (int)(s.charAt(i)-' ');
            if(dp[val]!=-1){
                ans=Math.max(ans,removeLessAndCountValid(dp,dp[val]));
            }
            dp[val]=i;
        }
        return Math.max(ans, removeLessAndCountValid(dp,0));
    }
    public int removeLessAndCountValid(int []dp, int val){
        int valid=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>=0){
                valid++;
                if(dp[i]<val)dp[i]=-1;
            }
        }
        return valid;
    }
}
