package p0501_0600.p0567_permutation_in_string;

import javax.print.attribute.standard.OrientationRequested;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given two strings, [s1] and [s2], return [true] if [s2] contains a permutation of [s1] or [false] otherwise.
In other words, return [true] if one of [s1]'s permutation is the substring of [s2].

Constraints:
    1 <= s1.length, s2.length <= 10^4
    s1 and s2 consist of lowercase English letters.
 */
public class Solution
{
    public boolean checkInclusion(String s1, String s2){
        // Check for edge cases.
        if (s1.length() > s2.length() ) return false;
        if (s2.isEmpty()){
            return s1.isEmpty();
        }

        // get the lengths of each of the strings.
        int x = s1.length(), y = s2.length();

        int[] array1 = new int[26];
        int[] array2 = new int[26];

        for (int i = 0; i < x; i++){
            array1[s1.charAt(i) - 'a'] ++;
            array2[s1.charAt(i) - 'a'] ++;
        }

        for (int i = x; i < y; i ++) {
            if (Arrays.equals(array1, array2)) return true;

        }


        return false;
    }
}
