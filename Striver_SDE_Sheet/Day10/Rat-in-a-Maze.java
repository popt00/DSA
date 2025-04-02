class Solution {
    // Function to find all possible paths
    int[][] arr;
    ArrayList<String> ans;
    char[] path;
    int pathIndex;
    int n;
    
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        n=mat.size();
        arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=mat.get(i).get(j)-1;
                //0 is okay, -1 is not okay
            }
        }
        
        ans=new ArrayList<>();
        path=new char[n*n];
        pathIndex=0;
        if(arr[0][0]==0){
            arr[0][0]=-1;
            findAll(0,0);
        }
        Collections.sort(ans);
        return ans;
    }
    public void findAll(int i, int j){
        if(i==n-1 && j==n-1){
            ans.add(getString());
            return;
        }
        if(i+1<n && arr[i+1][j]==0){
            arr[i+1][j]=1;path[pathIndex++]='D';
            findAll(i+1,j);
            arr[i+1][j]=0; pathIndex--;
        }
        if(j-1>=0 && arr[i][j-1]==0){
            arr[i][j-1]=1;path[pathIndex++]='L';
            findAll(i,j-1);
            arr[i][j-1]=0; pathIndex--;
        }
        if(j+1<n && arr[i][j+1]==0){
            arr[i][j+1]=1;path[pathIndex++]='R';
            findAll(i,j+1);
            arr[i][j+1]=0; pathIndex--;
        }
        if(i-1>=0 && arr[i-1][j]==0){
            arr[i-1][j]=1;path[pathIndex++]='U';
            findAll(i-1,j);
            arr[i-1][j]=0; pathIndex--;
        }
    }
    public String getString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<pathIndex;i++){
            sb.append(path[i]);
        }
        return sb.toString();
    }
}
