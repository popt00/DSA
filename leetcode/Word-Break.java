//https://leetcode.com/problems/word-break/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp= new boolean[n+1];
        dp[n]=true;
        outer: for(int i=n-1;i>=0;i--){
            for(String str: wordDict){
                if(str.length()+i <=n && dp[str.length()+i]==true){
                    if(isSame(i,s,str)){
                        dp[i]=true;
                        continue outer;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
    public boolean isSame(int i, String s, String str){
        int j=0;
        while(j<str.length()){
            if(s.charAt(i)!=str.charAt(j))return false;
            i++;j++;
        }
        return true;
    }
}
