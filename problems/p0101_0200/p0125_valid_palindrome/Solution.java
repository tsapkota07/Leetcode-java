package p0101_0200.p0125_valid_palindrome;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include
letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */

public class Solution
{

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // skip non-alphanumeric character from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
            {
                left ++;
            }

            // skip non-alphanumeric character from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }

            // compare lowercase.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left ++;
            right --;
        }

        return true;

    }
}
/*
Pattern:
Two Pointers

Core Idea:
Just denote the first and last character and compare them.
After each iteration, move them one step closer towards the middle.
    if one of them is not a number or Digit, skip that and move on to the next.
    do this for either left or right
    if left and right pointer don't have same character, return false.
let the loop run till (left = right or left > right)
exit loop after left < right is no longer valid and return true.

Why brute force fails:
Brute force would aim to reverse the array, taking O(n) time at the very least.

Edge Cases:
When there is a single or two element, but this is handled by the while loop properly.

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
First, I started working on this without reading the problem description or the prerequisites.
Then, I used a for loop to go from i to last, without using a while loop.

Signal (how to recognize this pattern next time):
When need to compare elements from both the ends of a sequence.
checking for symmetry
input is a string and array, and order matters.
 */
