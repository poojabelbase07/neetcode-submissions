class Solution {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {

            for (int currAmount = coin; currAmount <= amount; currAmount++) {

                dp[currAmount] += dp[currAmount - coin];
            }
        }

        return dp[amount];
    }
}