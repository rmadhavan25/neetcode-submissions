class Solution {
    public boolean isPalindrome(String s) {

        /* use 2 pointers and skip the special chars using ascii range*/

        int pointer1 = 0;
        int pointer2 = s.length()-1;

        while(pointer1 <= pointer2){
            while(isSpecialCharacter(s.charAt(pointer1))){
                pointer1++;
                if(pointer1 > pointer2){
                    pointer1--;
                    break;
                }
                    
            }
            while(isSpecialCharacter(s.charAt(pointer2))){
                pointer2--;
                if(pointer1 > pointer2){
                    pointer2++;
                    break;
                }
                    
            }

            if(Character.toLowerCase(s.charAt(pointer1)) != Character.toLowerCase(s.charAt(pointer2))){
                System.out.println(pointer1+" "+pointer2);
                return false;
            }
            else{
                pointer1++;
                pointer2--;
            }
        }

        return true;

        
    }

    public boolean isSpecialCharacter(Character c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
            return false;
        }
        else
            return true;
    }
}
