// Runner class asked to chat gpt.
package p0001_0100.p0001_two_sum;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] nums, int target, String name) {
        int[] res = s.twoSum(nums, target);

        System.out.println("==== " + name + " ====");
        System.out.println("nums   = " + Arrays.toString(nums));
        System.out.println("target = " + target);
        System.out.println("result = " + Arrays.toString(res));

        if (res == null) {
            System.out.println("❌ FAIL: returned null\n");
            return;
        }

        if (res.length != 2) {
            System.out.println("❌ FAIL: result length must be 2\n");
            return;
        }

        int i = res[0];
        int j = res[1];

        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
            System.out.println("❌ FAIL: index out of bounds (i=" + i + ", j=" + j + ")\n");
            return;
        }

        if (i == j) {
            System.out.println("❌ FAIL: used same index twice\n");
            return;
        }

        int sum = nums[i] + nums[j];
        if (sum != target) {
            System.out.println("❌ FAIL: nums[i] + nums[j] = " + sum + " (expected " + target + ")");
        } else {
            System.out.println("✅ PASS: nums[" + i + "] + nums[" + j + "] = "
                    + nums[i] + " + " + nums[j] + " = " + target);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{2, 7, 11, 15}, 9, "Classic example");
        runTest(s, new int[]{3, 2, 4}, 6, "Unsorted");
        runTest(s, new int[]{2, 0, 1, 4}, 6, "Includes zero");
        runTest(s, new int[]{-3, 4, 3, 90}, 0, "Negatives");
        runTest(s, new int[]{-10, -20, 5, 7}, -30, "Two negatives");
        runTest(s, new int[]{1, 5, 9, 13, 20}, 21, "Ends pair");

        // Large but SAFE values (no overflow)
        runTest(s, new int[]{500_000_000, 400_000_000, 100_000_000},
                900_000_000,
                "Large safe values");
    }
}