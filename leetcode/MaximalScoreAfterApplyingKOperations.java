//https://leetcode.com/problems/maximal-score-after-applying-k-operations/
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> ar=new PriorityQueue<Integer>(2,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return Integer.compare(b,a);
            }
    });
        for(int x:nums){
            ar.add(x);
        }
        long ans=0;
        while(k-->0){
            int x= ar.poll();
            ans+=x;
            ar.add(x/3+ (x%3==0?0:1));
        }
        return ans;
    }
}
