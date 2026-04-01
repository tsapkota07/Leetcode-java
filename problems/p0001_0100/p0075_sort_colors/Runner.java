package p0001_0100.p0075_sort_colors;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] nums, int[] expected, String name) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        s.sortColors(copy);

        System.out.println("==== " + name + " ====");
        System.out.println("input    = " + Arrays.toString(nums));
        System.out.println("expected = " + Arrays.toString(expected));
        System.out.println("result   = " + Arrays.toString(copy));

        boolean pass = Arrays.equals(copy, expected);

        if (pass) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{2,0,2,1,1,0}, new int[]{0,0,1,1,2,2}, "Basic example");
        runTest(s, new int[]{2,0,1}, new int[]{0,1,2}, "Small case");
        runTest(s, new int[]{0}, new int[]{0}, "Single zero");
        runTest(s, new int[]{1}, new int[]{1}, "Single one");
        runTest(s, new int[]{2}, new int[]{2}, "Single two");
        runTest(s, new int[]{0,0,0}, new int[]{0,0,0}, "All zeros");
        runTest(s, new int[]{2,2,2}, new int[]{2,2,2}, "All twos");
        runTest(s, new int[]{1,1,1}, new int[]{1,1,1}, "All ones");
        runTest(s, new int[]{2,1,0}, new int[]{0,1,2}, "Reverse order");
    }
}