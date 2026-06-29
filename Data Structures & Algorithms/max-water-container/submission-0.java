class Solution {
    public int maxArea(int[] heights) {
        
        int multiplier = heights.length - 1;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int maxArea = 0;

        while(leftPointer<rightPointer){
            int capacity = 0;
            if(heights[leftPointer]<heights[rightPointer]){
                capacity = multiplier*heights[leftPointer];
                if(capacity>maxArea)
                    maxArea = capacity;
                
                leftPointer++;
            }

            else if(heights[rightPointer]<=heights[leftPointer]){
                capacity = multiplier*heights[rightPointer];
                if(capacity>maxArea)
                    maxArea = capacity;

                rightPointer--;
            }

            multiplier--;
        }
        
        return maxArea;
    }
}
