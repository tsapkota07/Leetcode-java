package p0001_0100.p0011_container_with_most_water;

import java.util.Arrays;

public class Runner {

    private static void runTest(Solution s, int[] height, int expected, String name) {
        int[] copy = Arrays.copyOf(height, height.length);
        int result = s.maxArea(copy);

        System.out.println("==== " + name + " ====");
        System.out.println("height   = " + Arrays.toString(height));
        System.out.println("expected = " + expected);
        System.out.println("result   = " + result);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, new int[]{1,8,6,2,5,4,8,3,7}, 49, "Classic example");
        runTest(s, new int[]{1,1}, 1, "Two elements");
        runTest(s, new int[]{4,3,2,1,4}, 16, "Symmetric heights");
        runTest(s, new int[]{1,2,1}, 2, "Small case");
        runTest(s, new int[]{2,3,4,5,18,17,6}, 17, "Mixed values");
        runTest(s, new int[]{1,2,4,3}, 4, "Short array");
    }
}