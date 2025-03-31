class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length, rotate_len=matrix.length/2;
        for(int i=0;i<rotate_len;i++){ //4/2 =2 : 0,1
            for(int j=0;j<rotate_len;j++){
                rotate(matrix,i,j);
            }
        }
        if(n%2==1)for(int i=0;i<rotate_len;i++)rotate(matrix,i,rotate_len);
    }
    public void rotate(int[][] arr, int i, int j){
        ///{1} {0,1}..... n=4 {1,3}, {3,2}, {2,0}
        // {i,j}, {j,n-i-1},{n-i-1, n-j-1}, {n-j-1, i}
        int temp=arr[i][j],n=arr.length;
        arr[i][j]=arr[n-j-1][i];
        arr[n-j-1][i]=arr[n-i-1][n-j-1];
        arr[n-i-1][n-j-1]=arr[j][n-i-1];
        arr[j][n-i-1]=temp;
    }
}
