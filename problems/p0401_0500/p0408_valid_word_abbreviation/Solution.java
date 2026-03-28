package p0401_0500.p0408_valid_word_abbreviation;
/*
A string can be shortened by replacing any number of non-adjacent, non-empty
substrings with their lengths (without leading zeroes)

For example, the string "implementation" can be abbreviated in several ways, such as:
    "i12n" -> ("i mplementatio n")
    "imp4n5n" -> ("imp leme n tatio n")
    "14" -> ("implementation")
    "implemetation" -> (no substrings replaced)

Invalid abbreviations include:
    "i57n" -> (i mplem entatio n, adjacent substrings are replaced.)
    "i012n" -> (has leading zeros)
    "i0mplementation" (replaces an empty substring)

You are given a string named word and an abbreviation named abbr,
return true if abbr correctly abbreviates word, otherwise return false.
A substring is a contiguous non-empty sequence of characters within a string.

Constraints:
- 1 <= word.length <= 100
- word is made up of only lowercase English letters.
- 1 <= abbr.length <= 100
- abbr is made up of lowercase English letters and digits.
- All digit-only substrings of abbr fit in a 32-bit integer.
 */
public class Solution
{
    public boolean validWordAbbreviation (String word, String abbr){
        int wordPointer = 0;
        int abbrPointer = 0;

        while (wordPointer < word.length() && abbrPointer < abbr.length()){
            // Handle cases
            // These are going to be if-else
            // if both pointers are same letters.



            // else if abbrPointer is a letter
            //


            // else if abbrPointer is a 0


            // else if abbrPointer is non-zero digit.
                //  implement something call sublength. initialize it to 0.
                // while (abbrPointer < abbr.length() and abbr[abbrPointer] isn't a alphabet,
                    // sublength = sublength * 10 + integer value of abbr[abbrPointer]
                // increase i by sublength.


        }


        return (wordPointer == word.length() && abbrPointer == abbr.length());
    }
}
