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

        if (s1.length() > s2.length()) return false;

        // get the lengths of each of the strings.
        int s1Len = s1.length(), s2Len = s2.length();

        // Initialize arrays to store counts of each chars in the array.
        int[] array1 = new int[26];
        int[] array2 = new int[26];

        // Store the counts of all elements of s1. Store the count of first s1Len elements of s1.
        for (int i = 0; i < s1Len; i++){
            array1[s1.charAt(i) - 'a'] ++;
            array2[s2.charAt(i) - 'a'] ++;
        }

        // Iterate from the initial window, and keep moving the window.
        for (int i = s1Len; i < s2Len; i ++) {
            // if array2 matches array1 return true.
            if (Arrays.equals(array1, array2)) return true;

            // remove the leftmost element of the window, then add one element to the right in the window.
            array2[s2.charAt(i-s1Len) - 'a'] --;
            array2[s2.charAt(i) - 'a'] ++;
        }

        // return true if array1 and array2 are equal, which isn't handled by the last iteration in the above for
        //      loop. return false otherwise.
        return Arrays.equals(array1, array2);
    }
}
/*
Pattern:
Use of array to store char counts, Sliding window, two pointers.

Core Idea:
We use a sliding window. Suppose we have [k] elements in s1.
We use array1 to store counts of all the elements inside of s1. We use array2 to keep count of the all the elements in
    the current window inside of s2.
First, we add count all elements from s1 to add to array1. Alongside, we add the count of the first k elements of s2.
Then, we use a for loop to move our window, which is a fixed size of s1's length. Each loop, we compare the two arrays
    to see if they are equal to each other. If so we return true right then and there.
AT the very end, we return false. Arrays.equals(array1, array2) is basically a safeguard if our for loop misbehaves.

Why brute force fails:
Brute force would have to use several arrays to store each of the contents of the sliding window then compare against
    every one.

Edge Cases:
s1 longer than s2, repeated characters, and match occurring in the final window

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
Tried to use a hashmap again for this. I accidentally didn't count the elements of s2 in the first window.

Signal (how to recognize this pattern next time):
Need to check whether one strings permutation exists as a substring of another.

*/
