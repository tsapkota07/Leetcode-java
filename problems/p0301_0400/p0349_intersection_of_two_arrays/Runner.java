// asked gpt to generate this.

package p0301_0400.p0349_intersection_of_two_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Runner {

    private static void runTest(Solution s,
                                int[] nums1,
                                int[] nums2,
                                int[] expected,
                                String name) {

        int[] result = s.intersection(nums1, nums2);

        System.out.println("==== " + name + " ====");
        System.out.println("nums1    = " + Arrays.toString(nums1));
        System.out.println("nums2    = " + Arrays.toString(nums2));
        System.out.println("expected = " + Arrays.toString(expected));
        System.out.println("result   = " + Arrays.toString(result));

        Set<Integer> expectedSet = new HashSet<>();
        for (int n : expected) expectedSet.add(n);

        Set<Integer> resultSet = new HashSet<>();
        for (int n : result) resultSet.add(n);

        if (expectedSet.equals(resultSet)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // Basic intersection
        runTest(s,
                new int[]{1, 2, 2, 1},
                new int[]{2, 2},
                new int[]{2},
                "Basic duplicate intersection");

        // Multiple intersection values
        runTest(s,
                new int[]{4, 9, 5},
                new int[]{9, 4, 9, 8, 4},
                new int[]{4, 9},
                "Multiple values");

        // No intersection
        runTest(s,
                new int[]{1, 3, 5},
                new int[]{2, 4, 6},
                new int[]{},
                "No intersection");

        // One empty array
        runTest(s,
                new int[]{},
                new int[]{1, 2, 3},
                new int[]{},
                "One empty");

        // Both empty
        runTest(s,
                new int[]{},
                new int[]{},
                new int[]{},
                "Both empty");

        // Identical arrays
        runTest(s,
                new int[]{7, 8, 9},
                new int[]{7, 8, 9},
                new int[]{7, 8, 9},
                "Identical arrays");
    }
}