class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length-1 == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
        // if(prices.length-1 == 0) return 0;
        // int result = 0;
        // int min = prices[0];
        // for (int i = 1; i < prices.length; i++) {
        //     if (prices[i] < min){
        //         min= prices[i];
        //     }else if(prices[i]-min > result){
        //         result = prices[i] - min;
        //     }
        // }
        // return(result);

        // int result = 0;
        // if(prices.length-1 == 0) return 0;
        // for(int i = 0;i < prices.length;i++){
        //     for (int j = i + 1; j < prices.length; j++) {
        //         System.out.println(prices[j] - prices[i]);
        //         if((prices[j] - prices[i]) > result && j > i){
        //             result = prices[j] - prices[i];
        //         }
        //     }
        // }
        // return(result);
    }
}
