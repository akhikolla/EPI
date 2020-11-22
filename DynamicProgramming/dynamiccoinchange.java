class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 0 ; i < amount+1 ; i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;
        int result = 0;
        for(int i = 1 ; i < amount+1 ; i++){
            for(int j = 0; j < coins.length; j++){
                result = i - coins[j];
                if(result >= 0){
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}