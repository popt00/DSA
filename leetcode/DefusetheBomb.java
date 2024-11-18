//https://leetcode.com/problems/defuse-the-bomb
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[] ans=new int[n];
        if(k==0)return ans;
        int sum=0,index=n-1;
        if(k<0){
            k=-k;
            index=k;
        }
        for(int i=0;i<k;i++)sum+=code[i];
        for(int i=0;i<n;i++){
            ans[(index++)%n]=sum;
            sum-=code[i];
            sum+=code[(i+k)%n];
        }
        return ans;
    }
}
