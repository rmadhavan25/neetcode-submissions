class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int bottom = matrix.length-1;
        int top = 0;

        //int left = 0;
        // int right = matrix[0].length-1;

        //first iterate the rows and find which row
        // while(top<=bottom){
        //     int mid1 = top + (bottom-top)/2;
        //     int left = mid1;
        //     // if(matrix[mid1][0]==target || matrix[mid1][matrix[0].length-1]==target)
        //     //     return true;
        //     if(matrix[mid1][0]<=target && matrix[mid1][matrix[0].length-1]>=target){
        //         //found the row, binary search this row
        //         while(left<=right){
        //         int mid = left + (right-left)/2;

        //         if(matrix[left][mid]==target)
        //             return true;
        //         else if(matrix[left][mid]<target)
        //             left = mid+1;
        //         else
        //             right = mid-1;
        //         }
        //     }
        //     else{
        //         if(matrix[mid1][0]<target)
        //             top = mid1+1;
        //         else
        //             bottom = mid1-1;

        //     }
        // }
        // Phase 1: Binary search to find the correct row
while(top <= bottom) {
    int mid_row = top + (bottom - top) / 2;
    if(matrix[mid_row][0] <= target && matrix[mid_row][matrix[0].length-1] >= target) {
        // Found the row, now binary search within it
        int col_left = 0, col_right = matrix[0].length - 1;
        while(col_left <= col_right) {
            int col_mid = col_left + (col_right - col_left) / 2;
            if(matrix[mid_row][col_mid] == target)
                return true;
            else if(matrix[mid_row][col_mid] < target)
                col_left = col_mid + 1;
            else
                col_right = col_mid - 1;
        }
        return false;
    }
    else if(matrix[mid_row][0] > target)
        bottom = mid_row - 1;
    else
        top = mid_row + 1;
}
        return false;
    }
}
