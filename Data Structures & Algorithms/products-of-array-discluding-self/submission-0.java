class Solution {
    public int[] productExceptSelf(int[] nums) {


        /* using prefix and suffix sum technique */

        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int suffixIndex = nums.length-1;

        for(int i = 0;i<nums.length; i++){
            //populate prifix and suffix
            if(i == 0){
                prefix[i] = nums[i];
                suffix[suffixIndex] = nums[nums.length-1];
                suffixIndex--;
            }
            else{
                prefix[i] = nums[i]*prefix[i-1];
                suffix[suffixIndex] = suffix[suffixIndex+1] * nums[nums.length-1-i];
                suffixIndex--;
            }
        }

        for(int i = 0;i<nums.length;i++){
            if(i==0){
                result[i] = suffix[i+1];
            }
            else if(i == nums.length-1){
                result[i] = prefix[i-1];
            }
            else{
                result[i] = prefix[i-1] * suffix[i+1];
            }
        }
        return result;
        
    }
}  
