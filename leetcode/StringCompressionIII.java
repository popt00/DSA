//https://leetcode.com/problems/string-compression-iii
class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        int i=0,n=word.length();
        while(i<n){
            int j=0;
            while(i+j<n && j<9 && word.charAt(i+j)==word.charAt(i))j++;
            sb.append(j);
            sb.append(word.charAt(i));
            i=i+j;
        }
        return sb.toString();
    }
}
