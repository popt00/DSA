//https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii
class Solution {
    public int minimumPushes(String word) {
        int[] ch=new int[26];
        for(char x: word.toCharArray()){
            ch[(int)(x-'a')]++;
        }
        Arrays.sort(ch);
        int ans=0;
        for(int i=25;i>=0;i--){
            ans+= ((25-i)/8+1)*ch[i];
        }
        return ans;
    }
}
