package org.example;

public class Main {

    public static int countWaysToMakeSum(int[] coins, int targetSum) {
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int amount = coin; amount <= targetSum; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        return dp[targetSum];
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        int result = countWaysToMakeSum(coins, sum);
        System.out.println("방법의 수: " + result);
    }
}