//https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair
import java.util.SortedMap;
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int time= times[targetFriend][0];
        Arrays.sort(times, new Comparator<int[]>(){
            public int compare(int []a, int[]b){
                return Integer.compare(a[0],b[0]);
            }
        });
        SortedSet<Integer> emptyChairs=new TreeSet<>();
        for(int i=0;i<times.length;i++){emptyChairs.add(i);}
        SortedMap<Integer,ArrayList<Integer>> leavingChair=new TreeMap<>();
        leavingChair.put(10000000,new ArrayList<Integer>());
        int index=0;
        for(int i=0;i<times.length;i++){
            int st= times[i][0],ed=times[i][1];
            while(leavingChair.firstKey()<=st){
                // ArrayList<Integer>= ;
                for(Integer x: leavingChair.get(leavingChair.firstKey())){
                    emptyChairs.add(x);
                }
                leavingChair.remove(leavingChair.firstKey());
            }
            // current will sit on this chair:
            int currentChair= emptyChairs.first();
            if(time==st)return currentChair;
            //will put end point to this chair
            emptyChairs.remove(currentChair);
            if(leavingChair.get(ed)==null){
                leavingChair.put(ed,new ArrayList<Integer>());
            }
            leavingChair.get(ed).add(currentChair);
        }
        return emptyChairs.first();
    }
}
