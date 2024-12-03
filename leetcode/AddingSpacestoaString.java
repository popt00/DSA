//https://leetcode.com/problems/adding-spaces-to-a-string/
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb= new StringBuilder();
        int st=0;
        for(int ind : spaces){
            sb.append(s.substring(st,ind)+" ");
            st=ind;
        }
        sb.append(s.substring(st,s.length()));
        return sb.toString();
    }
}
