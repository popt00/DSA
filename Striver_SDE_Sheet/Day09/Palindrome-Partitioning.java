class Solution {
    List<List<String>> ans;
    List<String> curr;
    char[] arr;
    StringBuilder sb;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        curr=new ArrayList<>();
        arr= s.toCharArray();
        sb=new StringBuilder();
        recur(arr.length-1);
        return ans;
    }
    public void recur(int i){
        if(i==-1){
            ans.add(new ArrayList<>(curr));
            return;
        }
        int j=i;
        while(j>=0){
            if(isPalin(j,i)){
                curr.addFirst(getStr(j,i));
                recur(j-1);
                curr.removeFirst();
            }
            j--;
        }
    }
    public boolean isPalin(int st, int ed){
        while(st<ed){
            if(arr[st]!=arr[ed])return false;
            st++;ed--;
        }
        return true;
    }
    public String getStr(int st, int ed){
        sb.setLength(0);
        while(st<=ed){
            sb.append(arr[st]);
            st++;
        }
        return sb.toString();
    }
}
