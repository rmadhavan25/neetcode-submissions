/*
sort the pairs(position, speed) of array in descending order of position

calculate the no of steps to reach dest using -> (target-position) / speed

push the step count in a stack. keep pushing if top is smaller, else 
pop if new element is smaller(i.e faster) 

this way, the stack has one representive for each fleet, so no of fleet is equal to
stack size at end of assessing all pairs
 */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //int fleet = 0;

        int[][] pair = new int[position.length][2];

        for(int i = 0;i<position.length;i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for(int[] p : pair){
            stack.push((double)(target-p[0])/p[1]);
            if(stack.size()>=2 && stack.peek() <= stack.get(stack.size()-2)){
                stack.pop();
            }
        }

        return stack.size();
    }
}
