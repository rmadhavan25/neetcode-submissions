class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the max from piles

        int max = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int r = max;
        int res = 1;

        while(l<=r){
            int mid = l + (r-l)/2;
            long totalHours = 0;

            for(int p : piles){
                totalHours += Math.ceil((double)p/mid);
            }

            if(totalHours<=h){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return res;

    }
}
