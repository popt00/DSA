/**
 * https://leetcode.com/problems/average-waiting-time/
 * intution: we can solve each order wait time by que-time
 */
class Solution {
    public double averageWaitingTime(int[][] customers) {
        long t=0;
        long wait=0;
        for(int[] c:customers){
            if(t<c[0])t=c[0];
            t=t+1l*c[1];
            wait=wait+(long)(t-c[0]);
        }
        return (double)(wait)/customers.length;
    }
}