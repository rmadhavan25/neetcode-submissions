class Solution {
    public int trap(int[] height) {

        /** for each given index, the amount of water it can hold is
        equal to min(leftMax, rightMax) - index height
        
        to find the leftMax and rightMax: move the left pointer if leftMax<RightMax
        and vice-versa. it can also be seen as moving the pointer who's max value is lesser
        when compared to the other **/
        if(height.length == 1)
            return 0;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int maxWaterArea = 0;

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while(leftPointer < rightPointer){
            if(leftMax <= rightMax){
               leftPointer++;
               if(leftMax - height[leftPointer] > 0){
                maxWaterArea += leftMax - height[leftPointer];
               }
               if(height[leftPointer] > leftMax){
                leftMax = height[leftPointer];
               }
            }
            else {
                rightPointer--;
                if(rightMax - height[rightPointer] > 0){
                    maxWaterArea += rightMax - height[rightPointer];
                }
                if(height[rightPointer] > rightMax){
                rightMax = height[rightPointer];
               }
            }
        }

        return maxWaterArea;
    }
}