package p0101_0200.p0121_best_time_to_buy_and_sell_stock;
/*
You are given an array [prices] where prices[i] is the price of a given stock on
the [ith] day. You want to maximize your profit by choosing a single day to buy one
stock and then choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot
receive any profit, return [0].

Constraints:

1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
 */
public class Solution
{
    public int maxProfit (int[] prices) {
        int leastSoFar = prices[0];
        int profitIfSoldToday = 0;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            if (leastSoFar > prices[i]){
                leastSoFar = prices[i];
            }
            profitIfSoldToday = prices[i] - leastSoFar;

            if (profitIfSoldToday > max) {
                max = profitIfSoldToday;
            }
        }

        return max;
    }
}
/*
Pattern:
Sliding Window

Core Idea:
Think we have two pointers. One is the least so far. Another is the current
number. We also keep a running record of the max so far, which is initialized to 0.
Moreover, for each iteration, we calculate profitIfSoldToday, which we use to
potentially update max. Initialize leastSoFar to the first number.
iterate from first to last number.
- if least so far greater than current number, make leastSoFar that number.
- calculate the profit if we sold right now. do this by current number - leastSoFar
- if profitIfSoldNow is more than the current max, change the value of max to currentProfit.
- Iteration finished. Return max at the end.
Why brute force fails:
Brute force would have to calculate each possibility, which would be O(n^2) time.

Edge Cases:
When the price decreases only going left to right in the array.

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
I compared leastSoFar to see if leastSoFar is less than currentNumber, which doesn't really
    make sense.

Signal (how to recognize this pattern next time):
If needed to iterate through the array to find specific value such as max or min for
    subarray or substring if a string is involved.
 */