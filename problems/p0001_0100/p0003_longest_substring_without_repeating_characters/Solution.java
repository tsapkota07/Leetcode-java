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
                max = Math.max (max, set.size());
            }
            else{
                set.remove(s.charAt(leftSubstringPointer));
                leftSubstringPointer++;
            }
        }
        return max;

    }
}
/*
Pattern:
Sliding Window, Two Pointers, Hash Set.

Core Idea:
We got two pointers. Say the one at the left of any substring is aPointer and the right is bPointer.
We initialize them at the first and second position. Add the first positions to the hash set while
    we deal with edge case of less than 2 elements in the string.
We loop through the whole string till bPointer reaches the very end.
    - If set doesn't contain right element (element pointed by bPointer), we add it, recalculate max, increase the pointer
    - If set contains right element, we remove the left element, then increment the left pointer.
We then return max. Simple.

Why brute force fails:
Brute force would have to keep a track of the longest, and calculate the longest substring in each time. I beleive
it would take O(n^3) time even.

Edge Cases:
When there is only one element or no element in the string.
When all the elements are the same or all are different.

Complexity:
Time: O(n)
Space: O(n)

Mistakes:
- I used a HashMap to also include the position of each char along with the char at first, which was not really
    necessary
- I would calculate the max, outside  the if else block, which is fine but, I would also increment the right pointer
    there instead of the if block.

Signal (how to recognize this pattern next time):
- If we need to find something with a substring or subsequence given a string or a list.
- If we need to find out some range of elements given a string or list.
 */
