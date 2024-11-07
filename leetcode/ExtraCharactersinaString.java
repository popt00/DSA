//https://leetcode.com/problems/extra-characters-in-a-string/
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        int[] dp = new int[n+1];
        dp[0]=0;
        HashSet<String>set=new HashSet<>();
        for(String str:dictionary)set.add(str);
        for(int i=1;i<=n;i++){
            dp[i]=i;
            for(int j=i-1;j>=0;j--){
                dp[i]=Math.min(dp[i],dp[j]+i-j);
                if(set.contains(s.substring(j,i)))dp[i]=Math.min(dp[i],dp[j]);
            }
        }
        return dp[n];
    }
}
