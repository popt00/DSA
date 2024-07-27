/*
* https://leetcode.com/problems/minimum-cost-to-convert-string-ii/
*/
class Solution {
    int len=0;
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        Integer index=0;
        Trie root=new Trie();
        //adding all string to get index (like adding to arraylist)
        for(int i=0;i<original.length;i++){
            root.get(original[i]);root.get(changed[i]);
        }
        //adjacent matrix for original to target
        int n=len;
        int[][] adj=new int[n][n];
        for(int i=0;i<n;i++){Arrays.fill(adj[i],Integer.MAX_VALUE);adj[i][i]=0;}
        for(int i=0;i<cost.length;i++){
            int oriIndex=root.get(original[i]), chaIndex=root.get(changed[i]);
            adj[oriIndex][chaIndex]=Math.min(adj[oriIndex][chaIndex],cost[i]);
        }
        //as a->b, b->c is there then a->c will be there so doing floyd warshall algorithm
        floydWarshall(adj);
        return helper(source.toCharArray(),target.toCharArray(),adj,root);
    }

    public long helper(char[] s, char[] t, int[][] adj,Trie root){
        int m=s.length;
        long[] dp=new long[m+1];
        for(int i=0;i<=m;i++)dp[i]=Long.MAX_VALUE;
        dp[0]=0;
        
        for(int i=0;i<m;i++){
            if(dp[i]==Long.MAX_VALUE)continue;
            if(s[i]==t[i])dp[i+1]=Math.min(dp[i+1],dp[i]);

            //as we are searching from root everytime
            Trie souTrie=root,tarTrie=root;
            inner: for(int j=i;j<m;j++){
                //if we get index from source and target we can find adj[i][j] of that
                souTrie=souTrie.child[(int)(s[j]-'a')];
                tarTrie=tarTrie.child[(int)(t[j]-'a')];
                //if we do not have any souce or target then there is no point in going further
                if(souTrie==null || tarTrie == null){break inner;}
                if(souTrie.val!=-1 && tarTrie.val!=-1 && adj[souTrie.val][tarTrie.val] != Integer.MAX_VALUE){
                    dp[j+1]=Math.min(dp[j+1],adj[souTrie.val][tarTrie.val]+dp[i]);
                }
            }
        }
        return dp[m]==Long.MAX_VALUE?-1:dp[m];
    }
    public void floydWarshall(int [][] adj){
        int n=adj.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(adj[i][k]!=Integer.MAX_VALUE)
                    for(int j=0;j<n;j++){
                        if(adj[k][j]!=Integer.MAX_VALUE && adj[i][j]>adj[i][k]+adj[k][j]){
                            adj[i][j]=adj[i][k]+adj[k][j];
                        }
                    }
            }
        }
    }

    class Trie{
        int val;
        Trie[] child;
        Trie(){child=new Trie[26];val=-1;}
        int get(String str){//serves as both add or get str
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
