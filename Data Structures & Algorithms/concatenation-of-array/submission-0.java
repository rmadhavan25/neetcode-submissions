class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        int ansPointer = 0;

        for(int right = 0; right<nums.length; right++){
            ans[ansPointer] = nums[right];
            ans[ansPointer + nums.length] = nums[right];
            ansPointer++;
        }

        return ans;
    }
}