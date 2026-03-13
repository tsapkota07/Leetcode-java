package p0201_0300.p0242_valid_anagram;

public class Runner {

    private static void runTest(Solution s, String str1, String str2, boolean expected, String name) {
        boolean result = s.isAnagram(str1, str2);

        System.out.println("==== " + name + " ====");
        System.out.println("s        = \"" + str1 + "\"");
        System.out.println("t        = \"" + str2 + "\"");
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

        // Basic valid anagram
        runTest(s, "anagram", "nagaram", true, "Basic valid");

        // Not an anagram
        runTest(s, "rat", "car", false, "Basic invalid");

        // Same single character
        runTest(s, "a", "a", true, "Single character");

        // Different lengths
        runTest(s, "abc", "ab", false, "Different lengths");

        // Repeated characters valid
        runTest(s, "aabbcc", "abcabc", true, "Repeated valid");

        // Repeated characters invalid
        runTest(s, "aabbcc", "aabbc", false, "Repeated invalid");

        // Completely different
        runTest(s, "hello", "world", false, "Completely different");

        // Long identical strings
        runTest(s, "abcdefghijklmnopqrstuvwxyz",
                "zyxwvutsrqponmlkjihgfedcba",
                true,
                "Full alphabet reversed");
    }
}