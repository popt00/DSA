class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n=start.length;
        int[][] times=new int[n][2];
        for(int i=0;i<n;i++){times[i][0]=start[i];times[i][1]=end[i];}
        Arrays.sort(times, new Comparator<>(){
            public int compare(int[] a, int[]b){
                if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            }
        });
        int count=0,i=0,endVal=-1;
        while(i<n){
            if(times[i][1]<=endVal || times[i][0]>endVal){
                if(times[i][0]>endVal)count++;
                endVal=times[i][1];
            }
            i++;
        }
        return count;
    }
}
