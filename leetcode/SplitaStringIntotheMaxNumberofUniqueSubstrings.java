//https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
class Solution {
    HashSet<String> set;
    int ans;
    public int maxUniqueSplit(String s) {
        ans=0;
        set = new HashSet<>();
        recur(s,0);
        //  System.out.print(set);
        return ans;
    }
    public void recur(String s, int i){
        if(i==s.length()){
            ans=Math.max(ans,set.size());
            return;
        }
        int j=i;
        while(j<s.length()){
            String temp=s.substring(i,j+1);
            if(!set.contains(temp)){
                set.add(temp);
                recur(s,j+1);
                set.remove(temp);
            }
            j++;
        }
    }
}
