//https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
class Solution {
    public int minDays(int[][] grid) {
        if(isConnected(grid))return 0;
        if(one(grid))return 1;
        if(two(grid))return 2;
        return 3;
    }
    public boolean one(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(isConnected(grid)){
                        // System.out.println("["+i+","+j+"]");
                        grid[i][j]=1;
                        return true;
                    }
                    grid[i][j]=1;
                }
            }
        }
        return false;
    }
    public boolean two(int[][] grid){
        int m=grid.length,n=grid[0].length;
        int x=m*n;
        for(int i=0;i<x;i++){
            for(int j=i+1;j<x;j++){
                if(grid[i/n][i%n]==1 && grid[j/n][j%n]==1){
                    grid[i/n][i%n]=0;grid[j/n][j%n]=0;
                    if(isConnected(grid)){
                        // System.out.println("["+i/n+","+i%n+"],"+"["+j/n+","+j%n+"]");
                        grid[i/n][i%n]=1;grid[j/n][j%n]=1;
                        return true;
                    }
                    grid[i/n][i%n]=1;grid[j/n][j%n]=1;
                }
            }
        }
        return false;
    }
    public boolean isConnected(int[][] grid){
        //if there is max one land then it returns true
        int m=grid.length,n= grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int lands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){ //if once land is seen it will be visited and alll connected too
                    if(grid[i][j]==1){
                        lands++;// increases lands count
                        connect(vis,grid,i,j);
                    }
                }
            }
        }
        // System.out.println("lands: "+lands);
        return lands==0 || lands>1;
    }
    public void connect(boolean[][] vis, int[][] grid, int i, int j){
        vis[i][j]=true;// it is visited and then it's surrounding check if land is available
        if(i>0 && !vis[i-1][j] && grid[i-1][j]==1){connect(vis,grid,i-1,j);}
        if(i+1<grid.length && !vis[i+1][j] && grid[i+1][j]==1){connect(vis,grid,i+1,j);}
        if(j>0 && !vis[i][j-1] && grid[i][j-1]==1){connect(vis,grid,i,j-1);}
        if(j+1<grid[0].length && !vis[i][j+1] && grid[i][j+1]==1){connect(vis,grid,i,j+1);}
    }
}
