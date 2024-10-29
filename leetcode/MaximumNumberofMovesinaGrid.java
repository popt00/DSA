//https://leetcode.com/problems/maximum-number-of-moves-in-a-grid
class Solution {
    public int maxMoves(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][] dp=new boolean[m][n];
        boolean[][] added=new boolean[m][n];
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<m;i++){que.add(i*n);added[i][0]=true;}
        int maxJ=0;
        while(que.size()!=0){
            int index= que.poll();
            int i=index/n,j=index%n;
            maxJ=Math.max(maxJ,j);
            // System.out.print(que);System.out.println(i+","+j);
            if(j+1<n){
                if(i>0 && grid[i][j]<grid[i-1][j+1]){
                    dp[i-1][j+1]=true;
                    if(!added[i-1][j+1])que.add((i-1)*n+j+1);
                    added[i-1][j+1]=true;
                }
                if(grid[i][j]<grid[i][j+1]){
                    dp[i][j+1]=true;
                    if(!added[i][j+1])que.add((i)*n+j+1);
                    added[i][j+1]=true;
                }
                if(i+1<m &&grid[i][j]<grid[i+1][j+1]){
                    dp[i+1][j+1]=true;
                    if(!added[i+1][j+1])que.add((i+1)*n+j+1);
                    added[i+1][j+1]=true;
                }
            }
        }
        return maxJ;
    }
}
