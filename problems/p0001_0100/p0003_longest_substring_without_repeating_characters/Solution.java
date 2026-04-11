package p0001_0100.p0003_longest_substring_without_repeating_characters;

import java.util.HashSet;

/*
Given a string [s], find the length of the longest substring
without duplicate characters.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class Solution
{
    public int lengthOfLongestSubstring (String s) {
        HashSet<Character> set = new HashSet<>();
        int leftSubstringPointer = 0;
        int rightSubstringPointer = 1;
        int max = 1;

        if (s.length() < 2) {
            return s.length();
        }

        set.add(s.charAt(leftSubstringPointer));

        while (rightSubstringPointer < s.length()){
            if (!set.contains(s.charAt(rightSubstringPointer))){
                set.add(s.charAt(rightSubstringPointer));
                rightSubstringPointer ++;
            }
            else{
                set.remove(s.charAt(leftSubstringPointer));
                leftSubstringPointer++;
            }

            max = Math.max(max, rightSubstringPointer - leftSubstringPointer) ;
        }
        return max;

    }
}
