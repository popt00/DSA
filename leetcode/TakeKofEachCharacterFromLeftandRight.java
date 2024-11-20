//https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/
class Solution {
    public int takeCharacters(String s, int k) {
        if(k==0)return 0;
        int i=-1,j=s.length(),n=s.length();
        int ans= Integer.MAX_VALUE;
        int [] count=new int[3];
        // count[(int)(s.charAt(i)-'a')]++;
        //count[(int)(s.charAt(j)-'a')]++;
        while(i<n && i<j){
            if(checkArr(count,k)){
                ans=Math.min(i+n-j+1,ans);
                i++;
                if(i>=n)break;
                count[(int)(s.charAt(i)-'a')]++;
                while(j<n && checkArr(count,k)){
                    count[(int)(s.charAt(j)-'a')]--;
                    j++;
                }
            }
            else{
                j--;
                if(j<0)break;
                count[(int)(s.charAt(j)-'a')]++;
            }
            //System.out.println(i+","+j + ":"+ Arrays.toString(count)+","+checkArr(count,k));
        }
        return ans!=Integer.MAX_VALUE?ans:-1;
    }
    public boolean checkArr(int[] ar,int k){
        for(int x: ar){
            if(x<k)return false;
        }
        return true;
    }
}
