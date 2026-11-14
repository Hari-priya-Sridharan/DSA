class Solution {
    public int maxProfit(int[] prices) {
        int l=0, r=l+1, maxProfit=0;
        while(r<prices.length){
            if(prices[l]>prices[r]){
                l=r;
                r=l+1;
            }else{
                int profit = (prices[r]-prices[l]);
                maxProfit = Math.max(maxProfit,profit);
                r++;
            }
        }
        return maxProfit;
    }
}