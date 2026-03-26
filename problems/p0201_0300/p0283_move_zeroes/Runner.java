package p0201_0300.p0283_move_zeroes;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] nums, int[] expected, String name) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        s.moveZeroes(copy);

        System.out.println("==== " + name + " ====");
        System.out.println("input    = " + Arrays.toString(nums));
        System.out.println("expected = " + Arrays.toString(expected));
        System.out.println("result   = " + Arrays.toString(copy));

        if (Arrays.equals(copy, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{0,1,0,3,12}, new int[]{1,3,12,0,0}, "Basic example");
        runTest(s, new int[]{0,0,1}, new int[]{1,0,0}, "Zeros at start");
        runTest(s, new int[]{1,2,3}, new int[]{1,2,3}, "No zeros");
        runTest(s, new int[]{0,0,0}, new int[]{0,0,0}, "All zeros");
        runTest(s, new int[]{4,0,5,0,0,3}, new int[]{4,5,3,0,0,0}, "Mixed case");
        runTest(s, new int[]{1}, new int[]{1}, "Single element");
    }
}