
class Solution {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        java.util.Map<Character, Character> bracketPairs = new java.util.HashMap<>();

        bracketPairs.put(')','(');
        bracketPairs.put('}','{');
        bracketPairs.put(']','[');

        for(char c : s.toCharArray()){
            if(bracketPairs.containsKey(c)){
                if(!charStack.isEmpty() && charStack.peek()==bracketPairs.get(c)){
                    charStack.pop();
                }
                else{
                    return false;
                }
            }
            else
            charStack.push(c);
        }

        return charStack.isEmpty();
    }
}
