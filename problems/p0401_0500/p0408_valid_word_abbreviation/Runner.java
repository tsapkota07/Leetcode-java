package p0401_0500.p0408_valid_word_abbreviation;

public class Runner
{
    private static int passed = 0;
    private static int failed = 0;

    private static void runTest(Solution s, String word, String abbr, boolean expected, String name)
    {
        boolean result = s.validWordAbbreviation(word, abbr);

        System.out.println("==== " + name + " ====");
        System.out.println("word     = \"" + word + "\"");
        System.out.println("abbr     = \"" + abbr + "\"");
        System.out.println("expected = " + expected);
        System.out.println("result   = " + result);

        if (result == expected)
        {
            System.out.println("PASS");
            passed++;
        }
        else
        {
            System.out.println("FAIL");
            failed++;
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        // Basic valid cases
        runTest(s, "internationalization", "i12iz4n", true, "Valid abbreviation");
        runTest(s, "substitution", "s10n", true, "Full abbreviation");
        runTest(s, "implementation", "i12n", true, "Example valid");
        runTest(s, "implementation", "imp4n5n", true, "Another valid");
        runTest(s, "implementation", "14", true, "Entire word abbreviated");
        runTest(s, "word", "4", true, "Whole word replaced");
        runTest(s, "word", "3d", true, "Partial abbreviation");
        runTest(s, "apple", "5", true, "Whole word length abbreviation");
        runTest(s, "apple", "a4", true, "Keep first letter then skip rest");
        runTest(s, "apple", "4e", true, "Skip first four then match last");
        runTest(s, "apple", "2p2", true, "Valid skip-match-skip");
        runTest(s, "word", "2r1", true, "Valid middle match");

        // Basic invalid cases
        runTest(s, "apple", "a2e", false, "Invalid abbreviation");
        runTest(s, "implementation", "i57n", false, "Too large skip");
        runTest(s, "implementation", "i012n", false, "Leading zero invalid");
        runTest(s, "implementation", "i0mplementation", false, "Empty substring invalid");
        runTest(s, "apple", "6", false, "Skip beyond word length");
        runTest(s, "apple", "3d", false, "Final letter mismatch");
        runTest(s, "apple", "2l2", false, "Wrong middle letter");
        runTest(s, "word", "2o1", false, "Mismatched middle letter");


        // Exact match cases
        runTest(s, "word", "word", true, "No abbreviation exact match");
        runTest(s, "a", "a", true, "Single character exact match");
        runTest(s, "a", "1", true, "Single character abbreviated");
        runTest(s, "a", "2", false, "Single character overshoot");

        // Leading zero cases
        runTest(s, "word", "01rd", false, "Leading zero at start");
        runTest(s, "word", "w01d", false, "Leading zero in middle");
        runTest(s, "word", "w0rd", false, "Zero alone invalid");

        // Pointer ending / leftover checks
        runTest(s, "word", "wor", false, "Abbreviation ends too early");
        runTest(s, "word", "word1", false, "Abbreviation has extra skip after end");
        runTest(s, "word", "wordx", false, "Abbreviation has extra letter at end");
        runTest(s, "word", "5", false, "Skip one too many");
        runTest(s, "abbreviation", "a10", false, "Ends early after skip");
        runTest(s, "abbreviation", "a11", true, "Matches exact remaining length");

        // Multi-digit parsing checks
        runTest(s, "abcdefghijklmnop", "a14p", true, "Multi-digit skip valid");
        runTest(s, "abcdefghijklmnop", "a13p", false, "Multi-digit skip wrong amount");
        runTest(s, "substitution", "s010n", false, "Multi-digit leading zero invalid");
        runTest(s, "substitution", "12", true, "Entire word multi-digit length");
        runTest(s, "substitution", "13", false, "Entire word overshoot");

        // Mixed letter/number structure
        runTest(s, "banana", "b4a", true, "Valid mixed structure");
        runTest(s, "banana", "b3a1", false, "Ends with extra unmatched skip");
        runTest(s, "banana", "6", true, "Whole banana skipped");
        runTest(s, "banana", "5a", true, "Skip five then match last");
        runTest(s, "banana", "1a1a1a", true, "Alternating skip and match");
        runTest(s, "banana", "1a1a1", false, "Ends too early after pattern");

        // Summary
        System.out.println("==== SUMMARY ====");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total : " + (passed + failed));
    }
}

