class Solution {
    List<String> ans;
    StringBuilder sb;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        ArrayList<String>[] dp= new ArrayList[n+1];
        for(int i=0;i<=n;i++)dp[i]=new ArrayList<>();
        dp[n].add("");

        outer: for(int i=n-1;i>=0;i--){
            for(int j=0;j<wordDict.size();j++){
                String str=wordDict.get(j);
                if(str.length()+i <=n && dp[str.length()+i].size()!=0){
                    if(isSame(i,s,str)){
                        if(str.length()+i==n)
                            dp[i].add(str);
                        else for(String str2: dp[str.length()+i])
                            dp[i].add(str+" "+str2);
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
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
