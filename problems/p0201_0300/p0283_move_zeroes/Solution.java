package p0201_0300.p0283_move_zeroes;
/*
Given an integer array, nums, move all the 0s to the end of it while maintaining
the relative order of the non-zero elements.
Note that you must do this in place, without making a copy of the array.
 */
public class Solution
{
    public void moveZeroes(int[] nums) {
        // insertPosition is the position to put the next non-zero element in.
        int insertPosition = 0;
        int fast = 0;

        while (fast < nums.length) {
            // keep looping through.

            // if fast pointer is a non-negative number, put that value in insertPosition, then increment it by one.
            if (nums[fast] != 0) {
                nums[insertPosition] = nums[fast];
                insertPosition ++;
            }
            fast ++;
        }

        while (insertPosition < nums.length){
            nums[insertPosition] = 0;
            insertPosition ++;
        }


    }
}
/*

Pattern:
Two pointers. (Same direction)

Core Idea:
Use a fast and slow pointer.
one pointer is the insert Position, another pointer(fast) searches for non-zero number.
if fast points to a non-zero number, put that number in insert position, increment both pointers by 1.
if fast points to a 0, increment just the fast pointer.
After the fast pointer reaches and evaluates the last index, make everything after that index 0 to match
the results.

Why brute force fails:
brute force will need to create another array to store elements, which violates the constraints.

Edge Cases:
When there are no zeroes, or all zeroes.
When there is no element in the array. (no need to handle as no need to return anything.

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
Tried adding the zero for all elements but didn't add it to the last element after fast
crossed the last element.
Tried to implement a case for when we found the fast pointer pointing to zero, but wasn't necessary.

Signal (how to recognize this pattern next time):
When we need to do in place sorting, or ignore certain elements.
 */
