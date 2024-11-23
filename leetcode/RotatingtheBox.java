//https://leetcode.com/problems/rotating-the-box/description/
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m= box.length,n=box[0].length;
        char[][] ans=new char[n][m];
        for(int i=0;i<m;i++){
            int j=n-1,ik=m-i-1,jk=n-1,count=0;
            while(j>=0){
                if(box[i][j]=='#')count++;
                else if(box[i][j]=='*'){
                    while(count-->0)ans[jk--][ik]='#';
                    while(jk>=j)ans[jk--][ik]='.';
                    ans[j][ik]='*';
                    count=0;
                }
                j--;
            }
            while(count-->0)ans[jk--][ik]='#';
            while(jk>=0)ans[jk--][ik]='.';
        }
        return ans;
    }
}
