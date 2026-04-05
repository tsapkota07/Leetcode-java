package p0801_0900.p0844_backspace_string_compare;

/*
Given two strings [s] and [t], return [true] if they are equal when both are typed into empty text editors.
'#' means a backspace character.
Note that after backspacing an empty text, the text will remain emtpy.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

Constraints:
- 1 <= s.length, t.length <=200
- s and t only contain lowercase letters and '#' characters.
 */
public class Solution
{
    public boolean backspaceCompare (String s, String t ){

        int skips_S = 0;
        int skips_T = 0;

        int sPointer = s.length() -1;
        int tPointer = t.length() -1;
        while (sPointer >= 0 || tPointer >= 0){

            while (sPointer >=0) {
                if (s.charAt(sPointer) == '#'){
                    skips_S += 1;
                    sPointer --;
                }
                else if (skips_S > 0) {
                    skips_S --;
                    sPointer --;
                }
                else{
                    break;
                }
            }

            while (tPointer >=0) {
                if (t.charAt(tPointer) == '#'){
                    skips_T += 1;
                    tPointer --;
                }
                else if (skips_T > 0) {
                    skips_T --;
                    tPointer --;
                }
                else{
                    break;
                }
            }

            if ( (sPointer >= 0) && (tPointer >= 0) && (s.charAt(sPointer) != t.charAt(tPointer))  ){
                return false;
            }

            if ((sPointer >= 0) != (tPointer >= 0)){
                return false;
            }

            sPointer --;
            tPointer --;


        }
        return true;
    }
}
/*
Pattern:
Two pointers. Score increment and decrement.

Core Idea:
Two pointers for each String. Store the number of skips allowed for each string.
In a while loop, for each string, Scan from backward
    - if current char is # then increment skips && decrement Pointer.
    - if current char is not # but skips is > 0, then skip that char. Decrement skips by 1 & pointer by 1.
    - if current char is not # and skips == 0, then break out of the loop.
If, after exiting the loops, both pointers point to different char, return false. check if they're out of index or not first.
Implement another if statement to see if either of the pointers are out of index or not.

Why brute force fails:
Brute force would have to first collect the total no of skips for each string, remove chars starting from the right hand
    until we are depleted of the no of skips, starting from the index just before the last # till we run out of skips.
Then, it would be more complicated basically. Definitely would be more run time.

Edge Cases:
When there's unequal no of elements counting the #'s as -1 each time whenever we count the total no of elements.
When there's only one element in each string.

Complexity:
Time: O(n)
Space: O(n)

Mistakes:
I did && to check if pointers are less than zero or not instead of ||.
Didn't think I could implement strict check at the end for each outer while loop.

Signal (how to recognize this pattern next time):
 */
