class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<int[]> stack = new Stack<>();
        int[][] arr = new int[heights.length][2];
        int maxArea = 0;

        for(int i = 0;i<heights.length; i++){
            arr[i][0] = heights[i];
            arr[i][1] = i;
        }

        for(int i = 0; i <= heights.length; i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            if(stack.isEmpty() || stack.peek()[0] <= currentHeight){
                if (i < heights.length) stack.push(arr[i]);
            }
            else{
                int tempIndex = 0;
                while(!stack.isEmpty() && stack.peek()[0] > currentHeight){
                    int[] temp = stack.pop();
                    tempIndex = temp[1];
                    int area = temp[0] * (i - tempIndex);
                    maxArea = maxArea > area ? maxArea : area;
                }
                if (i < heights.length) {
                    arr[i][1] = tempIndex;
                    stack.push(arr[i]);
                }
            }
        }
        return maxArea;
    }
}