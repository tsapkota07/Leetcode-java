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
            char abbrChar = abbr.charAt(abbrPointer);
            char wordChar = word.charAt(wordPointer);
            // Handle cases
            // These are going to be if-else
            // if both pointers are same letters.
            if (abbrChar == wordChar){
                abbrPointer ++;
                wordPointer ++;
            }

            // else if abbrChar is a letter
            else if(Character.isLetter(abbrChar) ){
                System.out.println(abbr.charAt(abbrPointer) + " of abbreviation at index " + abbrPointer +
                        " does not match " + word.charAt(wordPointer) + " of word at index " + wordPointer + ".");
                return false;
            }


            // else if abbrChar is a 0
            else if (abbrChar == '0'){
                System.out.println("There is a 0 (zero) in the abbreviation at index: " + (abbrPointer + 1) );
                return false;
            }


            // else if abbrPointer is non-zero digit.
            else {
                int sublength = 0;
                while (abbrPointer < abbr.length() && Character.isDigit(abbr.charAt(abbrPointer))){
                    sublength = sublength * 10 + Character.getNumericValue(abbr.charAt(abbrPointer));
                    abbrPointer ++;
                }
                wordPointer = wordPointer + sublength;
            }
                //  implement something call sublength. initialize it to 0.
                // while (abbrPointer < abbr.length() and abbr[abbrPointer] isn't a alphabet,
                    // sublength = sublength * 10 + integer value of abbr[abbrPointer]
                // increase i by sublength.
        }


        return (wordPointer == word.length() && abbrPointer == abbr.length());
    }
}
/*
Pattern:
Two Pointers

Core Idea:
Set abbrPointer and wordPointer at the first element of abbr and word to represent current element.
Call these abbrChar and wordChar
if abbrChar == wordChar, move both pointer by 1.
if abbrChar is a letter and doesn't match wordChar, return false. invalid abbreviation.
if abbrChar is a 0, return false. invalid abbreviation.
if abbrChar is a valid int, see if the next few elements are integers
    if they are, parse them. eg: '123' becomes 123 and move wordPointer by 123.
    if the next element isn't an integer, move wordPointer by abbrChar's integer value.
return true only if all the elements were able to be compared.

Why brute force fails:
Don't know how i would even handle this would brute force. Definitely would be more time.

Edge Cases:
if there are no elements in abbr.
if word is fully abbreviated.

Complexity:
Time: O(word.length() + abbr.length())
Space: O(1)

Mistakes:
I forgot to check for equal letters and 0s at first.

Signal (how to recognize this pattern next time):
If needed to compare elements of two arrays consecutively.
 */
