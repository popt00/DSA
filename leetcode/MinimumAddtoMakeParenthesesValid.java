//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class Solution {
    public int minAddToMakeValid(String s) {
        int count=0,ans=0;
        for(char c: s.toCharArray()){
            if(c=='(')
                count++;
            else {
                count--;
                if(count<0){
                    count=0;
                    ans++;
                }
            }
        }
        return ans+count;
    }
}
