//https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i
class Solution {
    public int maximumLength(String s) {
        int n=s.length(),ans=-1,i=0;
        int[][] dp=new int[26][n+1];
        while(i<n){
            char c=s.charAt(i);
            int j=i;
            while(j<n && s.charAt(j)==c)j++;
            int len=j-i,chInd=(int)(c-'a');
            dp[chInd][len]++;
            if(len>0 && dp[chInd][len]>2)ans=Math.max(len,ans);
            if(len>1){
                dp[chInd][len-1]+=2;
                if(dp[chInd][len-1]>2)ans=Math.max(len-1,ans);
            }
            // System.out.println(ans+":["+i+","+j+"]"+chInd+",len="+len);
            if(len>2)ans=Math.max(len-2,ans);
            i=j;
        }
        return ans;
    }
}
