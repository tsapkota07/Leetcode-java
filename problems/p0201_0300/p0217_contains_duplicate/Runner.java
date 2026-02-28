package p0201_0300.p0217_contains_duplicate;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] nums, boolean expected, String name) {
        boolean result = s.containsDuplicate(nums);

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

        // Duplicate exists
        runTest(s, new int[]{1, 2, 3, 1}, true, "Simple duplicate");

        // No duplicate
        runTest(s, new int[]{1, 2, 3, 4}, false, "All distinct");

        // Early duplicate
        runTest(s, new int[]{5, 5, 6, 7, 8}, true, "Duplicate at start");

        // Late duplicate
        runTest(s, new int[]{9, 10, 11, 12, 9}, true, "Duplicate at end");

        // Negative numbers
        runTest(s, new int[]{-1, -2, -3, -1}, true, "Negative duplicate");

        // Single element
        runTest(s, new int[]{42}, false, "Single element");

        // Empty array
        runTest(s, new int[]{}, false, "Empty array");

        // Large distinct array
        runTest(s, new int[]{100, 200, 300, 400, 500}, false, "Large distinct");
    }
}