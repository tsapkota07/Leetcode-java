package p0901_1000.p0977_squares_of_a_sorted_array;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] nums, int[] expected, String name) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] result = s.sortedSquares(copy);

        System.out.println("==== " + name + " ====");
        System.out.println("nums     = " + Arrays.toString(nums));
        System.out.println("expected = " + Arrays.toString(expected));
        System.out.println("result   = " + Arrays.toString(result));

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}, "Mixed negatives and positives");
        runTest(s, new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121}, "Another mixed case");
        runTest(s, new int[]{0, 1, 2}, new int[]{0, 1, 4}, "All non-negative");
        runTest(s, new int[]{-3, -2, -1}, new int[]{1, 4, 9}, "All negative");
        runTest(s, new int[]{1}, new int[]{1}, "Single element");
        runTest(s, new int[]{}, new int[]{}, "Empty array");
    }
}