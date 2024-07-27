/*
* https://leetcode.com/problems/minimum-cost-to-convert-string-ii/
*/
class Solution {
    int len=0;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        Integer index=0;
        Trie strie=new Trie();
        for(int i=0;i<original.length;i++){
            strie.get(original[i]);strie.get(changed[i]);
        }
        int n=len;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){Arrays.fill(dp[i],Integer.MAX_VALUE);dp[i][i]=0;}
        for(int i=0;i<cost.length;i++){
            int oriIndex=strie.get(original[i]), chaIndex=strie.get(changed[i]);
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
        
        char[] s=source.toCharArray();char[] t=target.toCharArray();
        int m=source.length();
        long[] ans=new long[m+1];
        for(int i=0;i<=m;i++)ans[i]=Long.MAX_VALUE;
        ans[0]=0;
        for(int i=0;i<m;i++){
            if(ans[i]==Long.MAX_VALUE)continue;
            Trie souTrie=strie,tarTrie=strie;
            inner: for(int j=i;j<m;j++){
                souTrie=souTrie.child[(int)(s[j]-'a')];
                tarTrie=tarTrie.child[(int)(t[j]-'a')];
                if(souTrie==null || tarTrie == null){break inner;}
                if(souTrie.val!=-1 && tarTrie.val!=-1){
                    ans[j+1]=Math.min(ans[j+1],dp[souTrie.val][tarTrie.val]+ans[i]);
                }
            }
        }
        return ans[m]==Long.MAX_VALUE?-1:ans[m];
    }

    class Trie{
        int val;
        Trie[] child;
        Trie(){child=new Trie[26];val=-1;}
        int get(String str){
            char[]chstr =str.toCharArray();
            Trie temp=this;
            for(int i=0;i<chstr.length;i++){
                int index=(int)(chstr[i]-'a');
                if(temp.child[index]==null)temp.child[index]=new Trie();
                temp=temp.child[index];
            }
            if(temp.val==-1){temp.val=len++;}
            return temp.val;
        }
    }
}
