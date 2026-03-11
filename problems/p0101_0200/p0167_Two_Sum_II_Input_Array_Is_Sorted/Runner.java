package p0101_0200.p0167_Two_Sum_II_Input_Array_Is_Sorted;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] numbers, int target, int[] expected, String name) {
        int[] result = s.twoSum(numbers, target);

        System.out.println("==== " + name + " ====");
        System.out.println("numbers  = " + Arrays.toString(numbers));
        System.out.println("target   = " + target);
        System.out.println("expected = " + Arrays.toString(expected));
        System.out.println("result   = " + Arrays.toString(result));

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}, "Basic example");
        runTest(s, new int[]{2, 3, 4}, 6, new int[]{1, 3}, "Three elements");
        runTest(s, new int[]{-1, 0}, -1, new int[]{1, 2}, "Negative numbers");
        runTest(s, new int[]{1, 2, 3, 4, 4, 9}, 8, new int[]{4, 5}, "Duplicate values");
        runTest(s, new int[]{1, 3, 5, 7, 9}, 10, new int[]{1, 5}, "Ends of array");
    }
}