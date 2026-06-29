class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_length = matrix.length;
        int col_length = matrix[0].length;

        int top = 0;
        int bottom = row_length-1;

        while(top<=bottom){
            int row_mid = top + (bottom-top)/2;
            if(matrix[row_mid][0] == target)
                return true;
            else if(target>matrix[row_mid][0] && target<=matrix[row_mid][col_length-1]){
                //Row found, search within this row
                int left = 0;
                int right = col_length-1;
                while(left<=right){
                    int mid = left + (right-left)/2;

                if(matrix[row_mid][mid]==target)
                    return true;
                else if(matrix[row_mid][mid]<target)
                    left = mid+1;
                else
                    right = mid-1;
                }
                return false;
            }
            else{
                if(matrix[row_mid][0]<target){
                    top = row_mid+1;
                }
                else{
                    bottom = row_mid-1;
                }
            }
        }
        return false;
    }
}
