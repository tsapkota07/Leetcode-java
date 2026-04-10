package p0001_0100.p0003_longest_substring_without_repeating_characters;

import java.util.HashMap;
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
        HashMap<Character, Integer> map = new HashMap<>();
        int leftSubstringPointer = 0;
        int rightSubstringPointer = 1;
        int length = 1;
        int runningLength = 1;

        if (s.length() <2) {
            return s.length();
        }

        map.put(s.charAt(leftSubstringPointer),leftSubstringPointer);

        while (rightSubstringPointer < s.length()){
            while (map.containsKey(s.charAt(rightSubstringPointer)) ){
                runningLength = rightSubstringPointer - map.get(s.charAt(rightSubstringPointer)) + 1;
                map.remove(s.charAt(rightSubstringPointer));
                leftSubstringPointer ++;
                rightSubstringPointer ++;
            }

            map.put(s.charAt(rightSubstringPointer), rightSubstringPointer);
            length = Math.max(runningLength, length);
        }

        return length;

    }
}
