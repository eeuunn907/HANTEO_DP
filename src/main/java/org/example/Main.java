package org.example;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        // 합계 입력
        System.out.print("합계를 입력하세요: ");
        int sum = scanner.nextInt();

        // 동전 개수 및 동전 종류 입력
        System.out.print("동전 종류의 개수를 입력하세요: ");
        int n = scanner.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int result = countWaysToMakeSum(coins, sum);
        System.out.println("만들 수 있는 조합의 수: " + result);
    }
}