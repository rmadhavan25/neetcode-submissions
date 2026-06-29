class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /**
  Problem: Check if s2 contains any permutation of s1.

  Approach: Sliding Window + Frequency HashMap

  1) Store character frequencies of s1 in a HashMap.
     (Since only lowercase letters, space is O(26) → O(1))

  2) Traverse s2 using two pointers (lp and rp) forming a sliding window.

  3) When rp moves forward:
       - If s2[rp] exists in map, decrement its count.
       - Track when a character’s required count becomes zero.

  4) Maintain window size equal to s1.length():
       - If window size exceeds, move lp forward.
       - While moving lp, restore the character count in map.

  5) At any point, if all character counts are satisfied 
     (i.e., all required counts reached zero),
     then s2 contains a permutation of s1 → return true.

  6) If traversal completes without full match → return false.

  Time Complexity: O(|s2|)
  Space Complexity: O(1)
**/


        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int lp = 0, rp = 0;
        int required = map.size(); 

        while (rp < s2.length()) {
            char rightChar = s2.charAt(rp);

            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) required--;
            }

            rp++;

            // Keep window size equal to s1 length
            while (rp - lp > s1.length()) {
                char leftChar = s2.charAt(lp);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) required++;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                lp++;
            }

            // Check match
            if (required == 0) return true;
        }

        return false;
    }
}
