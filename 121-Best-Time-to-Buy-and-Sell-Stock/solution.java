class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        int lIndex = 0;
        int rIndex = 1;
        for (int i = 0; i < prices.length && rIndex< prices.length; i++) {
            if (prices[lIndex]> prices[i]){
                lIndex = i;
            }
            int profit = prices[rIndex]-prices[lIndex];
            max = Math.max(max,profit);
            rIndex++;
        }
        return max;
    }
}