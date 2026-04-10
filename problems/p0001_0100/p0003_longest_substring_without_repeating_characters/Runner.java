package p0001_0100.p0003_longest_substring_without_repeating_characters;

public class Runner {

    private static void runTest(Solution s, String str, int expected, String name) {
        int result = s.lengthOfLongestSubstring(str);

        System.out.println("==== " + name + " ====");
        System.out.println("string   = \"" + str + "\"");
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

        // Basic cases
        runTest(s, "abcabcbb", 3, "Classic - repeating pattern");
        runTest(s, "bbbbb", 1, "All same characters");
        runTest(s, "pwwkew", 3, "Mixed duplicates");
        runTest(s, "dvdf", 3, "Pattern with repeat at end");

        // Edge cases - length constraints
        runTest(s, "", 0, "Empty string");
        runTest(s, "a", 1, "Single character");

        // Two character variations
        runTest(s, "au", 2, "Two unique characters");
        runTest(s, "aa", 1, "Two same characters");

        // Repeats at different positions
        runTest(s, "aab", 2, "Repeat at start - should be 'ab'");
        runTest(s, "abba", 2, "Palindrome - should be 'ab' or 'ba'");
        runTest(s, "tmmzuxt", 5, "Repeat in middle");

        // All unique characters
        runTest(s, "abcdefghijklmnopqrstuvwxyz", 26, "All lowercase unique");
        runTest(s, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26, "All uppercase unique");

        // Character type coverage (letters, digits, symbols, spaces)
        runTest(s, " ", 1, "Single space");
        runTest(s, "a b c", 3, "With spaces - should be 'a b' or ' bc'");
        runTest(s, "0123456789", 10, "All digits unique");
        runTest(s, "!@#$%^&*()", 10, "All symbols unique");
        runTest(s, "a1!@", 4, "Mixed types");
        runTest(s, "a1!@a", 4, "Mixed types with repeat");

        // Longer meaningful strings
        runTest(s, "abcdefghijk", 11, "Long unique sequence");
        runTest(s, "abcdefghijka", 11, "Long with repeat at end");
        runTest(s, "au1a2u3", 4, "Pattern with digits and repeats");

        // Edge cases from typical LeetCode test suite
        runTest(s, "aaab", 2, "Multiple same then different");
        runTest(s, "baab", 2, "Different then multiple same");
        runTest(s, "abcabcbb", 3, "Classic LeetCode example");
    }
}
