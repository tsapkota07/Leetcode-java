package p0401_0500.p0408_valid_word_abbreviation;

public class Runner {

    private static void runTest(Solution s, String word, String abbr, boolean expected, String name) {
        boolean result = s.validWordAbbreviation(word, abbr);

        System.out.println("==== " + name + " ====");
        System.out.println("word     = \"" + word + "\"");
        System.out.println("abbr     = \"" + abbr + "\"");
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

        runTest(s, "internationalization", "i12iz4n", true, "Valid abbreviation");
        runTest(s, "apple", "a2e", false, "Invalid abbreviation");
        runTest(s, "substitution", "s10n", true, "Full abbreviation");
        runTest(s, "implementation", "i12n", true, "Example valid");
        runTest(s, "implementation", "imp4n5n", true, "Another valid");
        runTest(s, "implementation", "14", true, "Entire word abbreviated");
        runTest(s, "implementation", "i57n", false, "Adjacent replacement invalid");
        runTest(s, "implementation", "i012n", false, "Leading zero invalid");
        runTest(s, "implementation", "i0mplementation", false, "Empty substring invalid");
        runTest(s, "word", "4", true, "Whole word replaced");
        runTest(s, "word", "3d", true, "Partial abbreviation");
    }
}