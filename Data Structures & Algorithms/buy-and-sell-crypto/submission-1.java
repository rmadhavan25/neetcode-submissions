class Solution {
    public int maxProfit(int[] prices) {
        /** have leftPointer and rightPointer move leftPointer 
        if lp>rp and move rp if rp>lp **/
        if(prices.length == 1)
            return 0;

        int lp = 0;
        int rp = 1;
        int lowestPriceSoFar = prices[lp];
        int maxProfit = 0;

        while(rp < prices.length){
            if(prices[rp]<lowestPriceSoFar){
                lowestPriceSoFar = prices[rp];
                lp = rp;
                rp++;
            }
            else{
                maxProfit = maxProfit<(prices[rp]-prices[lp]) ? prices[rp]-prices[lp] : maxProfit;
                rp++;
            }
        }

        return maxProfit;
    }
}
