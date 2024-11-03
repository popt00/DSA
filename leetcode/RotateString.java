//https://leetcode.com/problems/rotate-string/
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        for(int i=0;i<s.length();i++){
            if(isSame(s,goal,i))return true;
        }
        return false;
    }
    public boolean isSame(String s, String g, int i){
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)!=g.charAt((i+j)%s.length()))return false;
        }
        return true;
    }
}
