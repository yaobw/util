package algorithm.easy;

/**
 * @description:122. 买卖股票的最佳时机 II
 * @author: yaobw
 * @date: 2020/8/19 4:36 下午
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                result += prices[i]-prices[i-1];
            }
        }
        return result;
    }
}
