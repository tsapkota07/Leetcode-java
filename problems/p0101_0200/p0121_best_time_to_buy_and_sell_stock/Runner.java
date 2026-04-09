package p0101_0200.p0121_best_time_to_buy_and_sell_stock;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] prices, int expected, String name) {
        int result = s.maxProfit(prices);

        System.out.println("==== " + name + " ====");
        System.out.println("prices   = " + Arrays.toString(prices));
        System.out.println("expected = " + expected);
        System.out.println("result   = " + result);

        if (result == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL: got " + result + ", expected " + expected);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{7, 1, 5, 3, 6, 4}, 5, "Buy at 1, sell at 6");
        runTest(s, new int[]{7, 6, 4, 3, 1}, 0, "Prices always decreasing");
        runTest(s, new int[]{2, 4, 1, 7, 5, 11}, 10, "Buy at 1, sell at 11");
        runTest(s, new int[]{1}, 0, "Single price");
        runTest(s, new int[]{1, 2, 3, 4, 5}, 4, "Always increasing");
        runTest(s, new int[]{5, 4, 3, 2, 1}, 0, "Always decreasing");
        runTest(s, new int[]{3, 2, 6, 5, 0, 3}, 4, "Multiple peaks");
    }
}
