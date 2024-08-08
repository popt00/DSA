//https://leetcode.com/problems/spiral-matrix-iii/
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rs, int cs) {
        int[][] ans=new int[rows*cols][2];
        int index=0;
        ans[index++]=new int[]{rs,cs};
        for(int i=1;index<ans.length;i++){
            //start point: 1(rs,cs+1),2[rs-1,cs+2]... i[rs-i+1,cs+i]
            // R,C = i(rs-i+1,cs+i)
            int R= rs-i+1, C= cs+i;
            //down: [(R,C) : (R+i*2-1,C)))  1,3,5
            if(C<cols && C>=0){
                int st=Math.max(R,0),ed=Math.min(R+i*2-1,rows),temp=C;
                for(int j=st;j<ed;j++){
                    ans[index++]=new int[]{j,temp};
                }
            }
            //left: [(R+i*2-1,C) : (R+i*2-1,C-i*2))  2,4,6,8
            if(R+i*2-1 <rows && R+i*2-1>=0){
                int st=Math.min(C,cols-1),ed=Math.max(C-i*2,-1),temp=R+i*2-1;
                for(int j=st;j>ed;j--){
                    ans[index++]=new int[]{temp,j};
                }
            }
            //top:  [(R+i*2-1,C-i*2) : (R-1,C-i*2))
            if(C-i*2 <cols && C-i*2>=0){
                int st=Math.min(R+i*2-1,rows-1),ed=Math.max(R-1,-1),temp=C-i*2;
                for(int j=st;j>ed;j--){
                    ans[index++]=new int[]{j,temp};
                }
            }
            //right: [(R-1,C-i*2) : (R-1,C+1))
            if(R-1 <rows && R-1>=0){
                int st=Math.max(C-i*2,0),ed=Math.min(C+1,cols),temp=R-1;
                for(int j=st;j<ed;j++){
                    ans[index++]=new int[]{temp,j};
                }
            }
        }
        return ans;
    }
}
