// asked gpt for runner

package p0301_0400.p0347_Top_K_Frequent_Elements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Runner {

    private static void runTest(Solution s,
                                int[] nums,
                                int k,
                                int[] expected,
                                String name) {

        int[] result = s.topKFrequent(nums, k);

        System.out.println("==== " + name + " ====");
        System.out.println("nums     = " + Arrays.toString(nums));
        System.out.println("k        = " + k);
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

        // Basic case
        runTest(s,
                new int[]{1, 1, 1, 2, 2, 3},
                2,
                new int[]{1, 2},
                "Basic example");

        // Single element
        runTest(s,
                new int[]{5},
                1,
                new int[]{5},
                "Single element");

        // All elements same frequency
        runTest(s,
                new int[]{4, 4, 6, 6, 7, 7},
                2,
                new int[]{4, 6}, // any 2 of the 3 unique values acceptable
                "Equal frequency");

        // k equals number of unique elements
        runTest(s,
                new int[]{1, 2, 3, 4},
                4,
                new int[]{1, 2, 3, 4},
                "k equals unique count");

        // Negative numbers
        runTest(s,
                new int[]{-1, -1, -2, -2, -2, -3},
                1,
                new int[]{-2},
                "Negative numbers");

        // Larger input
        runTest(s,
                new int[]{10, 10, 10, 20, 20, 30, 30, 30, 30},
                2,
                new int[]{10, 30},
                "Larger input");
    }
}