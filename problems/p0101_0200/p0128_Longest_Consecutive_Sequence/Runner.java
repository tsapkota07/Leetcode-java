package p0101_0200.p0128_Longest_Consecutive_Sequence;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] nums, int expected, String name) {
        int result = s.longestConsecutive(nums);

        System.out.println("==== " + name + " ====");
        System.out.println("nums     = " + Arrays.toString(nums));
        System.out.println("expected = " + expected);
        System.out.println("result   = " + result);

        if (result == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // Example from problem
        runTest(s,
                new int[]{100, 4, 200, 1, 3, 2},
                4,
                "Example case");

        // Already consecutive
        runTest(s,
                new int[]{1, 2, 3, 4, 5},
                5,
                "Already consecutive");

        // No consecutive numbers
        runTest(s,
                new int[]{10, 30, 50, 70},
                1,
                "No consecutive numbers");

        // Mixed order
        runTest(s,
                new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6},
                7,
                "Mixed order sequence");

        // Single element
        runTest(s,
                new int[]{42},
                1,
                "Single element");

        // Empty array
        runTest(s,
                new int[]{},
                0,
                "Empty array");

        // Negative numbers
        runTest(s,
                new int[]{-3, -2, -1, 0, 5, 6},
                4,
                "Negative numbers");
    }
}