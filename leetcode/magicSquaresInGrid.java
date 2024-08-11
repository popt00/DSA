//https://leetcode.com/problems/magic-squares-in-grid/
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int magicSquare=0;
        for(int i=1;i<grid.length-1;i++){
            for(int j=1;j<grid[0].length-1;j++){
                if(isMagicSquare(grid,i,j))magicSquare++;
            }
        }
        return magicSquare;
    }
    public boolean isMagicSquare(int[][] grid,int i,int j){
        boolean vis[]=new boolean[16];
        if(grid[i+1][j-1]+grid[i-1][j+1] != grid[i+1][j+1]+grid[i-1][j-1])return false;
        int[] row=new int[3];
        int[] col=new int[3];
        for(int ik=-1;ik<=1;ik++){
            for(int jk=-1;jk<=1;jk++){
                vis[grid[i+ik][j+jk]]=true;
                row[ik+1]+=grid[i+ik][j+jk];
                col[jk+1]+=grid[i+ik][j+jk];
            }
        }
        for(int k=0;k<3;k++)if(row[k]!=15 || col[k]!=15)return false;
        for(int k=1;k<=9;k++)if(!vis[k])return false;
        return true;
    }
}
