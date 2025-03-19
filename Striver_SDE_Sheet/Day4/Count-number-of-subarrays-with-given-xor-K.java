public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n=A.size(),currXor=0,ans=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        if(B!=0)map.put(0,1);
        for(Integer x: A){
            currXor=(currXor^x);
            ans+= map.getOrDefault(currXor^B,0);
            map.put(currXor, map.getOrDefault(currXor,0)+1);
        }
        return ans;
    }
}
