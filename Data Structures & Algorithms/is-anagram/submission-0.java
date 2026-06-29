class Solution {
    public boolean isAnagram(String s, String t) {

        //initializing a hashmap
        HashMap<Character, Integer> map = new HashMap<>();

        if(s.length()!=t.length())
            return false;

        //insert each char from string s into hashmap and increase the value by 1 for each occurrence
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i), 1);
            }    
            
        }

        //for each char in string t find the key and decrease the value by 1
        for(int i = 0;i<t.length();i++){
            if(map.containsKey(t.charAt(i)) == false)
                return false;
            else{
                if(map.get(t.charAt(i)) == 0)
                    return false;
                else
                    map.put(t.charAt(i), map.get(t.charAt(i))-1);
            }
            
        }

        return true;
    }
}
