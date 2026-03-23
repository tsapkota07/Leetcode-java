package p0001_0100.p0026_remove_duplicates_from_sorted_array;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s,
                                int[] nums,
                                int[] expectedNums,
                                String name) {

        int[] original = Arrays.copyOf(nums, nums.length);

        int k = s.removeDuplicates(nums);

        System.out.println("==== " + name + " ====");
        System.out.println("original = " + Arrays.toString(original));
        System.out.println("k        = " + k);
        System.out.println("result   = " + Arrays.toString(nums));
        System.out.println("expected = " + Arrays.toString(expectedNums));

        boolean pass = true;

        if (k != expectedNums.length) {
            pass = false;
        } else {
            for (int i = 0; i < k; i++) {
                if (nums[i] != expectedNums[i]) {
                    pass = false;
                    break;
                }
            }
        }

        if (pass) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s,
                new int[]{1,1,2},
                new int[]{1,2},
                "Basic case");

        runTest(s,
                new int[]{0,0,1,1,1,2,2,3,3,4},
                new int[]{0,1,2,3,4},
                "Multiple duplicates");

        runTest(s,
                new int[]{1,2,3},
                new int[]{1,2,3},
                "No duplicates");

        runTest(s,
                new int[]{1,1,1,1},
                new int[]{1},
                "All same");

        runTest(s,
                new int[]{},
                new int[]{},
                "Empty array");
    }
}