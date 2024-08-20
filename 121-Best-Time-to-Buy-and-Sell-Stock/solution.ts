function maxProfit(prices: number[]): number {
  let max = 0;
  let localMin = Number.MAX_SAFE_INTEGER;
  let localMinIndex = -1;
  for (let i = 0; i < prices.length; i++) {
    if (localMin> prices[i]){
        localMin = prices[i]
        localMinIndex = i
    }
    
    for (let j = localMinIndex; j < prices.length; j++) {
        const newPrice = prices[i];
        const oldPrice =  prices[j];
        
        const profit = newPrice-oldPrice
        max = Math.max(max,profit)
        
    }
  }
  return max;
}
