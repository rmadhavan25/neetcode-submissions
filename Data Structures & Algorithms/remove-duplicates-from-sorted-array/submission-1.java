class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int result = 1;
        nums[left] = nums[0];
        left++;
        for(int right = 1; right<nums.length;right++){
            if(nums[right-1] != nums[right]){
                nums[left] = nums[right];
                result++;
                left++;
            }
            
        }

        return result;
    }
}