public class Solution {
    public int Change(int amount, int[] coins) {
        int n = coins.Length;

        int[] dp = new int [amount + 1];
        dp[amount] = 1;

        for(int i = n - 1; i >= 0; i--){
            int[] nextDp = new int [amount + 1];
            nextDp[amount] = 1;

            for(int j = amount - 1; j >= 0; j--){
                nextDp[j] = dp[j];

                if(j + coins[i] <= amount){
                    nextDp[j] += nextDp[j + coins[i]];
                }
            }

            dp = nextDp;
        }
        
        return dp[0];
    }
}