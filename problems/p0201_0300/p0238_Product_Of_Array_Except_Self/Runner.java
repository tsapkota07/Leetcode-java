package p0201_0300.p0238_Product_Of_Array_Except_Self;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s,
                                int[] nums,
                                int[] expected,
                                String name) {

        int[] result = s.productExceptSelf(nums);

        System.out.println("==== " + name + " ====");
        System.out.println("nums     = " + Arrays.toString(nums));
        System.out.println("expected = " + Arrays.toString(expected));
        System.out.println("result   = " + Arrays.toString(result));

        if (Arrays.equals(result, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // Basic example
        runTest(s,
                new int[]{1, 2, 3, 4},
                new int[]{24, 12, 8, 6},
                "Basic example");

        // Contains one zero
        runTest(s,
                new int[]{1, 2, 0, 4},
                new int[]{0, 0, 8, 0},
                "One zero");

        // Contains two zeros
        runTest(s,
                new int[]{0, 2, 0, 4},
                new int[]{0, 0, 0, 0},
                "Two zeros");

        // Negative numbers
        runTest(s,
                new int[]{-1, 2, -3, 4},
                new int[]{-24, 12, -8, 6},
                "Negative numbers");

        // Single element
        runTest(s,
                new int[]{5},
                new int[]{1},
                "Single element");

        // All ones
        runTest(s,
                new int[]{1, 1, 1, 1},
                new int[]{1, 1, 1, 1},
                "All ones");
    }
}