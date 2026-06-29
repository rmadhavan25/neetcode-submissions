class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int [2];
        
        /** 1)store all the elements in a hashmap, with key 
        as the element and value as the index 

        2)traverse the array and find the difference between the target
        and current element and use containsmethod in the hashmap to
        see if there is a matching element. If so get that index and the
        current index and return
        **/

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                if(i != map.get(target - nums[i])){ // to make sure indices are not the same
                    result[0] = i;
                    result[1] = map.get(target - nums[i]);
                    break;
                }
                
            }
        }

        return result;

    }
}
