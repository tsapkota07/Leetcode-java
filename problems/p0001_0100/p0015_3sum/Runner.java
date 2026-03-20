package p0001_0100.p0015_3sum;

import java.util.*;

public class Runner {

    private static Set<String> normalize(List<List<Integer>> triplets) {
        Set<String> set = new HashSet<>();
        if (triplets == null) {
            return set;
        }

        for (List<Integer> triplet : triplets) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            set.add(sorted.toString());
        }

        return set;
    }

    private static boolean hasDuplicates(List<List<Integer>> triplets) {
        if (triplets == null) {
            return false;
        }

        Set<String> seen = new HashSet<>();
        for (List<Integer> triplet : triplets) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            String key = sorted.toString();

            if (!seen.add(key)) {
                return true;
            }
        }

        return false;
    }

    private static void runTest(Solution s, int[] nums, List<List<Integer>> expected, String name) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        List<List<Integer>> result = s.threeSum(copy);

        Set<String> expectedSet = normalize(expected);
        Set<String> resultSet = normalize(result);
        boolean duplicateFound = hasDuplicates(result);

        System.out.println("==== " + name + " ====");
        System.out.println("nums              = " + Arrays.toString(nums));
        System.out.println("expected          = " + expected);
        System.out.println("result            = " + result);
        System.out.println("normalized result = " + resultSet);
        System.out.println("duplicates in result? " + duplicateFound);

        if (expectedSet.equals(resultSet) && !duplicateFound) {
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

        runTest(
                s,
                new int[]{-1, -1, -1, 2, 2},
                Arrays.asList(
                        Arrays.asList(-1, -1, 2)
                ),
                "Duplicate-heavy case"
        );
    }
}