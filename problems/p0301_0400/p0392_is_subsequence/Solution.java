package p0301_0400.p0392_is_subsequence;
/*
Given two strings [s] and [t], return [true] if [s] is a subsequence of [t],
or [false] otherwise.
A subsequence of a string is a new string that is formed from the original string
by deleting some (can be none) of the characters without disturbing the relative
positions of the remaining characters (i.e "ace" is a subsequence of "abcde" while
"aec" is not).

Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 */
public class Solution
{
    public boolean isSubsequence(String s, String t)
    {
        int pointerForS = 0;
        int pointerForT = 0;

        char sChar;
        char tChar;

        if(t.isEmpty() && !s.isEmpty()) {
            return false;
        }

        if (s.isEmpty()){
            return true;
        }

        while (pointerForT < t.length() && pointerForS < s.length()){
            sChar = s.charAt(pointerForS);
            tChar = t.charAt(pointerForT);

            // if characters don't match, increment the pointer for T.
            if (sChar != tChar){
                pointerForT ++;
            }
            else
            // if characters match, increment both pointers.
            {
                pointerForS ++;
                pointerForT ++;
            }
        }

        return (pointerForS == s.length());
    }
}
/*
Pattern:
Good ol' Two Pointer.

Core Idea:
Put pointers on both [t] and [s]. We're checking if [s] is a subsequence of [t] or not.
- if pointers match (by this I mean the characters pointed to), increment both tPointer and sPointer.
- if pointers don't match, increment just the tPointer.
return true if pointerForS is the length of s as this just means we were able to confirm before s.length-1 to work.

Why brute force fails:
Takes exponential time.

Edge Cases:
s is empty → always true
t is empty but s is not → false

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
I made the return condition too strict, returning false if pointerForT didn't match t.length().

Signal (how to recognize this pattern next time):
Check if one string is a subsequence of another → use two pointers moving forward
 */