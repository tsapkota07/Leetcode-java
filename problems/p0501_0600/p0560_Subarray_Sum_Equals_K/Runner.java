package p0501_0600.p0560_Subarray_Sum_Equals_K;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] nums, int k, int expected, String name) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int result = s.subarraySum(copy, k);

        System.out.println("==== " + name + " ====");
        System.out.println("nums     = " + Arrays.toString(nums));
        System.out.println("k        = " + k);
        System.out.println("expected = " + expected);
        System.out.println("result   = " + result);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{1, 1, 1}, 2, 2, "Basic example");
        runTest(s, new int[]{1, 2, 3}, 3, 2, "Two subarrays");
        runTest(s, new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7, 4, "Mixed values");
        runTest(s, new int[]{1}, 1, 1, "Single element");
        runTest(s, new int[]{1, -1, 0}, 0, 3, "Includes negatives and zero");
        runTest(s, new int[]{0, 0, 0, 0}, 0, 10, "All zeros");
        runTest(s, new int[]{2, 4, 6}, 5, 0, "No matching subarray");
    }
}