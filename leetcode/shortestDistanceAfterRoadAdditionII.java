//https://leetcode.com/problems/shortest-distance-after-road-addition-queries-ii/
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m=queries.length;
        int[] ans=new int[m];


        //vis[i] is true if it is jumped, so we have to skip that query, as no intersecting paths
        boolean[] vis=new boolean[n];
        
        int[] next=new int[n]; // represents after jumping which next we have to go
        for(int i=0;i<n-1;i++)next[i]=i+1;//from que, we do one jump

        int steps=n-1;//how many jumps we did, as n nodes, n-1 jumps
        for(int i=0;i<m;i++){
            int x=queries[i][0],y=queries[i][1];
            if(!vis[x] && next[x]<y){ // if it is between jump then skip, if previous jump is smaller then skip
                int smaller_jumps=0;
                // we have to turn whole jump true
                for(int z=next[x];z<y;z++){// but as till next[x] is already true, we are only checking this interval
                    if(!vis[z]){// we also count how many small jumps we did before, so we can minus it from steps
                        vis[z]=true;// and we are skipping that jump as no intersecting path exist
                        smaller_jumps++;
                    }
                }
                steps-=smaller_jumps; // we are just taking one jump instead of smaller_jumps
                next[x]=y;// assigning next jump from x to y
            }
            ans[i]=steps;
        }
        return ans;
    }
}
