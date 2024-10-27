//https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
class Solution {
    public int countSquares(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[][] maxVert=getMaxVert(mat,m,n);
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int size=maxVert[i][j];
                int len=0;
                while(len<size && j-len>=0 && maxVert[i][j-len]>len){
                    size=Math.min(size,maxVert[i][j-len]);
                    ans++;
                    len++;
                }
            }
        }
        return ans;
    }
    public int[][] getMaxVert(int[][] mat, int m, int n){
        int[][] maxVert=new int[m][n];
        for(int j=0;j<n;j++)maxVert[0][j]=mat[0][j];
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                maxVert[i][j]=mat[i][j];
                if(mat[i][j]==1)maxVert[i][j]+=maxVert[i-1][j];
            }
            
        }
        return maxVert;
    }
}
