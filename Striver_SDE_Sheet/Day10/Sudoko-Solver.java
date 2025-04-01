class Solution {
    int[][] board;
    int minI=9,minJ=9;
    public void solveSudoku(char[][] board) {
        this.board=getInt(board);
        solve(0,0);
        getChar(board,this.board);
    }
    private boolean solve(int i, int j){
        if(i==9)return true;
        if(j==9)return solve(i+1,0);
        if(board[i][j]==0){
            for(int val=1;val<=9;val++){
                if(!isValid(i,j,val))continue;
                board[i][j]=val;
                if(solve(i,j+1))return true;
            }
            board[i][j]=0;
            return false; //we could not find value
        }
        return solve(i,j+1);
    }
    private boolean isValid(int i, int j, int val){
        int sqI=(i/3)*3, sqJ=(j/3)*3;
        for(int k=0;k<9;k++){
            if(board[k][j]==val)return false;
            if(board[i][k]==val)return false;
            if(board[sqI+k/3][sqJ+k%3]==val)return false;
        }
        return true;
    }
    private int[][] getInt(char[][] charBoard){
        int[][] intBoard=new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                intBoard[i][j]= (charBoard[i][j]=='.')?
                                    0:
                                    (int)(charBoard[i][j]-'0');
            }
        }
        return intBoard;
    }
    private void getChar(char[][] charBoard ,int[][] intBoard){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                charBoard[i][j] = (char)(intBoard[i][j]+'0');
            }
        }
    }
}
