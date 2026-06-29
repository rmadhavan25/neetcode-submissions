class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /* using 2 pointers */
        int pointer1 = 0;
        int pointer2 = numbers.length-1;
        int[] result = new int[2];

        for(int i = 0;i<numbers.length;i++){
            if(numbers[pointer1]+numbers[pointer2] == target){
                break;
            }
            else{
                if(numbers[pointer1]+numbers[pointer2] > target){
                    pointer2--;
                }
                else if(numbers[pointer1]+numbers[pointer2] < target){
                    pointer1++;
                }
            }
        }
        result[0] = pointer1+1;
        result[1] = pointer2+1;

        return result;
    }
}
