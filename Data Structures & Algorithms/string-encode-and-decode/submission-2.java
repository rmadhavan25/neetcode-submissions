class Solution {

    public String encode(List<String> strs) {

        StringBuffer sb = new StringBuffer();
        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        /**So we are gonna traverse the str from start to end.
        when we find a combination of a number and '#' sign, then we 
        break the part of the string and add it to result list **/
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
