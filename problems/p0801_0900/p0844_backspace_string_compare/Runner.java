package p0801_0900.p0844_backspace_string_compare;

public class Runner {

    private static void runTest(Solution s, String str1, String str2, boolean expected, String name) {
        boolean result = s.backspaceCompare(str1, str2);

        System.out.println("==== " + name + " ====");
        System.out.println("s        = \"" + str1 + "\"");
        System.out.println("t        = \"" + str2 + "\"");
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

        runTest(s, "ab#c", "ad#c", true, "Example 1");
        runTest(s, "ab##", "c#d#", true, "Example 2");
        runTest(s, "a#c", "b", false, "Example 3");

        runTest(s, "a##c", "#a#c", true, "Multiple backspaces");
        runTest(s, "a#b#c#d#", "", true, "All removed");
        runTest(s, "abc#d", "acc#c", false, "Different results");
        runTest(s, "####", "##", true, "Only backspaces");
        runTest(s, "bxj##tw", "bxo#j##tw", true, "Complex case");
    }
}