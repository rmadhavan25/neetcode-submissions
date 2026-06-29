class Solution {
    public int characterReplacement(String s, int k) {
        /** 
        1) we are gonna have 2 pointer lp and rp
        2) let them both start at index 0
        3)  insert the character at current rp index to a hashmap
        with its count
        4) now use this formula [length of current window - 
        highest occurring character as per current map] should be less
        <=k.
        5) keep moving the rp and update
        latest longest window and update it accordingly
        6)if the formula is > k; then start moving lp and updating map
        and repeat the process until rp reaches the end
          **/

        int lp = 0;
        int rp = 0;
        int currentLongestSubString = 0;
        int currentHighestCharOccurrence = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (rp<s.length()){
            if(map.containsKey(s.charAt(rp))){
                //update the integer value by 1;
                map.put(s.charAt(rp),map.get(s.charAt(rp))+1);
            }
            else{
                //add the character to map with integer count 1
                map.put(s.charAt(rp),1);
            }

            currentHighestCharOccurrence = map.get(s.charAt(rp)) > currentHighestCharOccurrence ?
                                            map.get(s.charAt(rp)) : currentHighestCharOccurrence;

            //check using formula
            while( ((rp - lp)+1) - currentHighestCharOccurrence > k){
                char leftChar = s.charAt(lp);
                map.put(leftChar, map.get(leftChar) - 1);
                lp++;
            }
            currentLongestSubString = 
                currentLongestSubString < (rp - lp)+1 ? (rp - lp)+1 : currentLongestSubString;
                rp++;

        }

        return currentLongestSubString;
    }
}
