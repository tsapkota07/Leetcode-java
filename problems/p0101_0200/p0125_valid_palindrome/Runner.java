package p0101_0200.p0125_valid_palindrome;

public class Runner {

    private static void runTest(Solution s, String input, boolean expected, String name) {
        boolean result = s.isPalindrome(input);

        System.out.println("==== " + name + " ====");
        System.out.println("input    = \"" + input + "\"");
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

        runTest(s, "A man, a plan, a canal: Panama", true, "Classic valid palindrome");
        runTest(s, "race a car", false, "Not a palindrome");
        runTest(s, " ", true, "Single space");
        runTest(s, "a", true, "Single character");
        runTest(s, "aa", true, "Two same characters");
        runTest(s, "ab", false, "Two different characters");
        runTest(s, "No lemon, no melon", true, "Phrase palindrome");
        runTest(s, "12321", true, "Numeric palindrome");
        runTest(s, "12345", false, "Numeric non-palindrome");
    }
}