class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        int result = 1;
        ArrayList<Integer> startingDigits = new ArrayList<>();
        HashSet<Integer> numSet = new HashSet<>();

        for(int i = 0;i<nums.length;i++){
            numSet.add(nums[i]);
        }

        for(int i = 0;i<nums.length;i++){
            if(!numSet.contains(nums[i]-1)){
                startingDigits.add(nums[i]);
            }
        }

        for(int digit : startingDigits){
            int count = 1;
            while(numSet.contains(digit+1)){
                count++;
                digit++;
            }
            if(count>result){
                result = count;
            }
        }

        return result;
    }
}
