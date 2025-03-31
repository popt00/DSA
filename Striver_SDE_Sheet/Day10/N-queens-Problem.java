class Solution {
    char[][] chr;
    List<List<String>> ans;
    int n;
    public List<List<String>> solveNQueens(int n) {
        chr=new char[n][n];
        this.n=n;
        for(int i=0;i<n;i++)Arrays.fill(chr[i],'.');
        ans=new ArrayList<>();
        recur(n-1);
        return ans;
    }
    public void recur(int i){
        if(i<0){
            List<String> curr=new ArrayList<>();
            for(char[] ch: chr){
                curr.add(new String(ch));
            }
            ans.add(curr);
            return;
        }
        for(int j=0;j<n;j++){
            if(!canAttack(i,j)){
                chr[i][j]='Q'; 
                recur(i-1);
                chr[i][j]='.';
            }
        }
    }
    public boolean canAttack(int i, int j){
        for(int k=0;k<n;k++){
            if(chr[i][k]=='Q' || chr[k][j]=='Q')return true;
            if(i-k>=0 && j-k>=0 && chr[i-k][j-k]=='Q')return true;
            if(i-k>=0 && j+k<n && chr[i-k][j+k]=='Q')return true;
            if(i+k<n && j-k>=0 && chr[i+k][j-k]=='Q')return true;
            if(i+k<n && j+k<n && chr[i+k][j+k]=='Q')return true;
        }
        return false;
    }
}
