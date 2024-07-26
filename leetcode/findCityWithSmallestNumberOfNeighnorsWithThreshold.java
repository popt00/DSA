/*
* https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
* Floyd-Warshall algorithm
*/
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //0-1::2 1-4:2 
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],Integer.MAX_VALUE);
        for(int[] edge: edges){
            dp[edge[0]][edge[1]]=edge[2];
            dp[edge[1]][edge[0]]=edge[2];
        }
        for(int i=0;i<n;i++){dp[i][i]=0;}
        //k is anchor point ij => min((ik+kj),ij)
        //do not use as 2 edges and min, use as anchor point i.e DO NOT USE kj => min((ki+ij),jk)
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(dp[i][k]!=Integer.MAX_VALUE)
                    for(int j=0;j<n;j++){
                        if(dp[k][j]!=Integer.MAX_VALUE && dp[i][j]>dp[i][k]+dp[k][j]){
                            dp[i][j]=dp[i][k]+dp[k][j];
                            dp[i][j]=dp[i][k]+dp[k][j];
                        }
                    }
            }
        }
        int ans=-1, ansNodes=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int currNodes=0;
            for(int j=0;j<n;j++){
                if(j!=i && dp[i][j]<=distanceThreshold)currNodes++;
            }
            if(ansNodes>=currNodes){
                ans=i;
                ansNodes=currNodes;
            }
            // System.out.println(Arrays.toString(dp[i])+i+":"+currNodes);
        }
        return ans;
    }
}
