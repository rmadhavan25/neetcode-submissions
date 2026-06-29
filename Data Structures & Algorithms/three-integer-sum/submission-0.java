
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i<nums.length-2;i++){
            if(nums[i]>0)
                break;
            //for every i: j should i+1 and k should be nums.length-1
            int j = i+1;
            int k = nums.length-1;

            while(k>j){
                int sum = nums[j]+nums[k]+nums[i];
                if(nums[j]+nums[k]+nums[i] == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1] ){
                        j++;
                    }
                }
                if(sum>0){
                    k--;
                }
                if(sum<0){
                    j++;
                }
            }

            while(i<nums.length-2 && nums[i]==nums[i+1]){
                i++;
            }
        }
        return result;
    }
}