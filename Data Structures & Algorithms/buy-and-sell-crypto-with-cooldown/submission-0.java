class Solution {

    public int maxProfit(int[] prices) {

        int hold = -prices[0]; // holding a stock
        int sold = 0;          // just sold today
        int rest = 0;          // cooldown / doing nothing

        for (int i = 1; i < prices.length; i++) {

            int prevSold = sold;

            sold = hold + prices[i];

            hold = Math.max(hold, rest - prices[i]);

            rest = Math.max(rest, prevSold);
        }

        return Math.max(sold, rest);
    }
}