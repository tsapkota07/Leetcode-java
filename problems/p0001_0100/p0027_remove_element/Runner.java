package p0001_0100.p0027_remove_element;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] nums, int val, int[] expectedNums, String name) {
        int[] copy = Arrays.copyOf(nums, nums.length);

        int k = s.removeElement(copy, val);

        System.out.println("==== " + name + " ====");
        System.out.println("nums         = " + Arrays.toString(nums));
        System.out.println("val          = " + val);
        System.out.println("expectedNums = " + Arrays.toString(expectedNums));
        System.out.println("k            = " + k);
        System.out.println("array after  = " + Arrays.toString(copy));

        boolean pass = true;

        // Check k
        if (k != expectedNums.length) {
            pass = false;
        }

        // Sort first k elements
        Arrays.sort(copy, 0, k);
        int[] expectedSorted = Arrays.copyOf(expectedNums, expectedNums.length);
        Arrays.sort(expectedSorted);

        // Compare first k elements
        for (int i = 0; i < k && pass; i++) {
            if (copy[i] != expectedSorted[i]) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{3,2,2,3}, 3, new int[]{2,2}, "Basic example");
        runTest(s, new int[]{0,1,2,2,3,0,4,2}, 2, new int[]{0,0,1,3,4}, "Multiple removals");
        runTest(s, new int[]{1,1,1}, 1, new int[]{}, "All removed");
        runTest(s, new int[]{1,2,3}, 4, new int[]{1,2,3}, "No removal");
        runTest(s, new int[]{2}, 2, new int[]{}, "Single element removed");
        runTest(s, new int[]{5}, 3, new int[]{5}, "Single element kept");
    }
}