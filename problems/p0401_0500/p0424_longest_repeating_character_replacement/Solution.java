package p0401_0500.p0424_longest_repeating_character_replacement;

import java.util.HashMap;
import java.util.HashSet;

/*
You are given a string [s] and an integer [k]. You can choose any character of the string and change it to any other
uppercase English letter. You can perform this at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exist other ways to achieve this answer too.

 */
public class Solution
{
    public int characterReplacement(String s, int k)
    {
        int LEN = s.length();
        char[] chars = new char[26];
        /*
        Here, chars[0] signifies 'A', chars[1] 'B' and so on till chars[25] being 'Z'
         */

        int windowStart = 0;
        int maxLength = 0;

        int maxCount = 0;
        int currentCharCount = 0;

        /*
        main thing here is that, we're always trying to expand the window. We only shrink the window if the no of different
        characters in our window asides from the one with maxCount exceeds the value k.
         */
        for (int windowEnd = 0; windowEnd < LEN; windowEnd ++) {
            chars[s.charAt(windowEnd) - 'A'] ++;
            currentCharCount = chars[s.charAt(windowEnd) - 'A'];

            maxCount = Math.max(maxCount, currentCharCount);

            /*
            windowEnd - windowStart + 1 is the size of the window. +1 is there cause we use zero based indexing (counting
                from zero instead of one. So when end pointer is at 2, start pointer is at 0, the actual size of the window
                should be 3. not 2-0 = 2. So we increment it by one. 2-0 + 1 = 3.
            maxCount is the count of the element with the most frequency inside the window. That means,whatever remains after
                we do window size minus the count of elements with the most frequency inside the window is the no of different
                elements we have in the array. We only change the start pointer if the no of different elements exceeds k.
             */
            while (windowEnd - windowStart + 1 - maxCount > k) {
                /*
                We change the charCount of character pointed to by windowStart, then update windowStart.
                 */
                chars[s.charAt(windowStart) - 'A'] --;
                windowStart ++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1) ;
        }

        return maxLength;
    }
}
/*
Pattern:
Sliding window, array representation of alphabets, two pointers

Core Idea:
always try to expand the window. Only stop when the no of different elements becomes greater than k.

Why brute force fails:
Brute force would take wayyy to long plus would be more complicated to design.

Edge Cases:
When there's no elements in the array. -> WE don't enter the for loop and just return 0.
When there's one element in the array -> We enter the for loop once, and then return 1.
When there's

Complexity:
Time: O(n)
Space: O(n)

Mistakes:
I thought that we had to shrink the window as soon as possible. WRONG. we expand it as long as we can.
I used HashSet to decrement/increment the charCount for each char but array is way easier.

Signal (how to recognize this pattern next time):
When allowed to modify at most k elements to make some window valid, and we need the longest such window, we think:
    windowSize minus mostFrequentElementCount has to be < = k.
 */
