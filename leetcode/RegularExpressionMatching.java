//https://leetcode.com/problems/regular-expression-matching/
class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s,p,s.length()-1,p.length()-1);
    }
    public boolean isMatch(String s, String p, int i, int j){
        if(j==-1)return i==-1;
        if(p.charAt(j)=='.' ||(i>=0 && s.charAt(i)==p.charAt(j)) )return isMatch(s,p,i-1,j-1);
        if(p.charAt(j)=='*'){
            j--;
            if(isMatch(s,p,i,j-1))return true;
            char chr= p.charAt(j);
            while(i>=0 && (s.charAt(i)==chr || chr=='.')){
                if(isMatch(s,p,i-1,j-1))return true;
                i--;
            }
        }
        return false;
    }
}
