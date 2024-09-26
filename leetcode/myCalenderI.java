//https://leetcode.com/problems/my-calendar-i/description/
class MyCalendar {
    ArrayList<int[]> ar;
    public MyCalendar() {
        ar=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int index = binarySearch(start);
        if(index>=0){ //imediate pre booking-bracket check
            if(ar.get(index)[0]==start)return false;
            if(ar.get(index)[1]>start)return false;
        }
        if(index+1<ar.size()){ //immediate next booking-bracket check
            if(ar.get(index+1)[0]<end)return false;
        }
        //if there is no overlapping we can add this booking-bracket
        ar.add(index+1,new int[]{start,end});
        return true;
    }
    // [index][0] <= start < [index+1][0]
    //if size 0, return -1
    public int binarySearch(int start){
        int i=0,j=ar.size()-1;
        if(ar.size()==0)return -1;
        if(ar.get(0)[0]>start)return -1;
        if(ar.get(j)[0]<=start)return j;
        while(i+1<j){
            int mid = (i+j)/2;
            if(ar.get(mid)[0]<=start)i=mid;
            else j=mid;
        }
        return i;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
