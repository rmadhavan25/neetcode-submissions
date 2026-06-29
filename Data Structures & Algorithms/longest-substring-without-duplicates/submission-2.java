class Solution {
    public int lengthOfLongestSubstring(String s) {
        /** have 2 pointers left and right at the 0th position
        1)keep increasing the right pointer and add the
        new character to hashset. 
        2)if the character is already present in the set, remove the 
        character from set
        3)keep moving the left pointer by 1 position and check
         until the repeated character is found and move lp by 1 again to new
         character
         **/

         int lp = 0;
         int rp = 0;
         int longestSubsequence = 0;
         int count = 0;
         HashSet<Character> temp = new HashSet<Character>();

         if(s.length()==0){
            return 0;
         }
         if(s.length() == 1){
            return 1;
         }

         while(rp<s.length()){
            if(!temp.contains(s.charAt(rp))){
                temp.add(s.charAt(rp));
                rp++;
                count++;
            }

            else{
                while(lp<=rp){
                    if(temp.contains(s.charAt(lp))){
                        temp.remove(s.charAt(lp));
                        lp++;
                        count--;
                        break;
                    }
                    lp++;
                    count--;
                }
                
            }
            longestSubsequence = count>longestSubsequence ? count : longestSubsequence;
         }

         return longestSubsequence;
    }
}
