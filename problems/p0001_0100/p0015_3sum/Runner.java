package p0001_0100.p0015_3sum;

import java.util.*;

public class Runner {

    private static void runTest(Solution s, int[] nums, List<List<Integer>> expected, String name) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        List<List<Integer>> result = s.threeSum(copy);

        System.out.println("==== " + name + " ====");
        System.out.println("nums     = " + Arrays.toString(nums));
        System.out.println("expected = " + expected);
        System.out.println("result   = " + result);

        Set<String> expectedSet = new HashSet<>();
        for (List<Integer> triplet : expected) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            expectedSet.add(sorted.toString());
        }

        Set<String> resultSet = new HashSet<>();
        if (result != null) {
            for (List<Integer> triplet : result) {
                List<Integer> sorted = new ArrayList<>(triplet);
                Collections.sort(sorted);
                resultSet.add(sorted.toString());
            }
        }

        if (expectedSet.equals(resultSet)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(
                s,
                new int[]{-1, 0, 1, 2, -1, -4},
                Arrays.asList(
                        Arrays.asList(-1, -1, 2),
                        Arrays.asList(-1, 0, 1)
                ),
                "Basic example"
        );

        runTest(
                s,
                new int[]{0, 1, 1},
                Collections.emptyList(),
                "No triplets"
        );

        runTest(
                s,
                new int[]{0, 0, 0},
                Arrays.asList(
                        Arrays.asList(0, 0, 0)
                ),
                "All zeros"
        );

        runTest(
                s,
                new int[]{-2, 0, 1, 1, 2},
                Arrays.asList(
                        Arrays.asList(-2, 0, 2),
                        Arrays.asList(-2, 1, 1)
                ),
                "Multiple triplets"
        );

        runTest(
                s,
                new int[]{1, 2, -2, -1},
                Collections.emptyList(),
                "No valid combination"
        );
    }
}