package p0401_0500.p0424_longest_repeating_character_replacement;

public class Runner {

    private static void runTest(Solution s, String input, int k, int expected, String name) {
        int result = s.characterReplacement(input, k);

        System.out.println("==== " + name + " ====");
        System.out.println("input    = \"" + input + "\"");
        System.out.println("k        = " + k);
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

        runTest(s, "ABAB", 2, 4, "Basic example");
        runTest(s, "AABABBA", 1, 4, "Leetcode example");
        runTest(s, "AAAA", 2, 4, "All same characters");
        runTest(s, "ABCDE", 1, 2, "All unique characters");
        runTest(s, "BAAAB", 2, 5, "Mixed characters");
        runTest(s, "ABBB", 2, 4, "Replace leading character");
        runTest(s, "AABA", 0, 2, "No replacements allowed");
        runTest(s, "A", 1, 1, "Single character");
        runTest(s, "ABAA", 0, 2, "No replacements, max run");
    }
}