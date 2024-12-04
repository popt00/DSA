//https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description/
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m=str1.length(),n=str2.length();
        int st1=0,st2=0;
        while(st1<m && st2<n){
            if(compare(str1.charAt(st1),str2.charAt(st2))){
                st2++;
            }
            st1++;
        }
        return st2==n;
    }
    public boolean compare(char a, char b){
        int diff= (int)(b-a);
        if(diff!= 0 && diff!=1 && diff!=-25)return false;
        return true;
    }
}
