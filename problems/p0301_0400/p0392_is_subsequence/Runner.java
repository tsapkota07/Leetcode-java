package p0301_0400.p0392_is_subsequence;

public class Runner {

    private static void runTest(Solution s, String s1, String s2, boolean expected, String name) {
        boolean result = s.isSubsequence(s1, s2);

        System.out.println("==== " + name + " ====");
        System.out.println("s        = \"" + s1 + "\"");
        System.out.println("t        = \"" + s2 + "\"");
        System.out.println("expected = " + expected);
        System.out.println("result   = " + result);

        if (result == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        runTest(s, "ace", "abcde", true, "Basic example");
        runTest(s, "aec", "abcde", false, "Not a subsequence");
        runTest(s, "", "abcde", true, "Empty s");
        runTest(s, "a", "", false, "Empty t");
        runTest(s, "", "", true, "Both empty");
        runTest(s, "abc", "ahbgdc", true, "Spread out characters");
        runTest(s, "axc", "ahbgdc", false, "Missing character");
        runTest(s, "a", "a", true, "Single character match");
        runTest(s, "b", "a", false, "Single character no match");
        runTest(s, "b", "abc", true, "Single character in middle");
        runTest(s, "c", "abc", true, "Single character at end");
        runTest(s, "a", "abc", true, "Single character at start");
        runTest(s, "aa", "aaa", true, "Repeated characters");
        runTest(s, "aaa", "aa", false, "s longer than t");
        runTest(s, "ab", "aabb", true, "Multiple occurrences");
        runTest(s, "ba", "aabb", false, "Wrong order");
        runTest(s, "xyz", "xyzabc", true, "At start with more chars");
        runTest(s, "z", "xyzabc", true, "Last char of longer string");
    }
}
