class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int st_row=0,ed_row=matrix.length-1;
        if(target<matrix[st_row][0])return false;
        while(st_row+1<ed_row){
            int mid= (st_row+ed_row)/2;
            if(matrix[mid][0]<=target)st_row=mid;
            else ed_row=mid;
        }
        int row= st_row;
        if(matrix[ed_row][0] <= target)row=ed_row;
        int st_col=0,ed_col= matrix[0].length-1;
        if(target<matrix[row][st_col] || matrix[row][ed_col]<target) return false;
        while(st_col+1<ed_col){
            int mid= (st_col+ed_col)/2;
            if(matrix[row][mid]<=target)st_col=mid;
            else ed_col=mid;
        }
        return matrix[row][st_col]==target || matrix[row][ed_col]==target;
    }
}
