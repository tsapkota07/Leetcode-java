package p0501_0600.p0567_permutation_in_string;

public class Runner {

    private static void runTest(Solution s, String s1, String s2, boolean expected, String name) {
        boolean result = s.checkInclusion(s1, s2);

        System.out.println("==== " + name + " ====");
        System.out.println("s1       = \"" + s1 + "\"");
        System.out.println("s2       = \"" + s2 + "\"");
        System.out.println("expected = " + expected);
        System.out.println("result   = " + result);

        if (result == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL: got " + result + ", expected " + expected);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // Basic cases - should be true
        runTest(s, "ab", "eidbaooo", true, "Basic permutation at start");
        runTest(s, "ab", "ab", true, "Identical strings");
        runTest(s, "ab", "ba", true, "Exact permutation");
        runTest(s, "a", "b", false, "Single different char");

        // Edge cases - length constraints
        runTest(s, "a", "a", true, "Single same char");
        runTest(s, "ab", "a", false, "s2 shorter than s1");

        // No permutation
        runTest(s, "ab", "cd", false, "No matching chars");
        runTest(s, "abc", "xyz", false, "Completely different");

        // Permutation in middle
        runTest(s, "ab", "eab", true, "Permutation at end");
        runTest(s, "ab", "eidb", false, "No complete permutation");
        runTest(s, "ab", "abcd", true, "Permutation at start of longer");

        // Repeated characters
        runTest(s, "aa", "aa", true, "Same repeated chars");
        runTest(s, "aab", "baab", true, "Repeated in permutation");
        runTest(s, "aab", "ab", false, "Missing character");

        // Longer strings
        runTest(s, "aab", "aabbaab", true, "Multiple permutations");
        runTest(s, "abc", "abcabc", true, "Repeated exact pattern");
        runTest(s, "abc", "defabc", true, "Permutation after non-match");

        // Edge cases with exact frequency matching
        runTest(s, "ab", "aac", false, "Extra character without match");
        runTest(s, "abc", "ababc", true, "Contains permutation");
        runTest(s, "abc", "abbc", false, "Frequency mismatch");

        // All unique characters in s1
        runTest(s, "abcdef", "fedcbagg", true, "All chars present");
        runTest(s, "abc", "xyzabc", true, "At end");
        runTest(s, "abc", "xyzacb", true, "Permuted at end");

        // s1 and s2 near max length behavior (but small for testing)
        runTest(s, "aabbcc", "aabbccddee", true, "Permutation at start");
        runTest(s, "xyz", "abcxyzdef", true, "Permutation in middle");
    }
}
