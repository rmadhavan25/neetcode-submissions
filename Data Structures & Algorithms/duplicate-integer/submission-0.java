class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> arr = new HashSet<>();

        for(int i = 0; i<nums.length;i++){
            arr.add(nums[i]);
        }

        return (nums.length - arr.size())>0 ? true : false;

    }
}