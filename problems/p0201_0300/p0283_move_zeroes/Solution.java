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
            if (nums[fast] != 0) {
                nums[insertPosition] = nums[fast];
            }

            if (fast == nums.length - 1 && insertPosition < fast) {
                insertPosition ++;
                nums[insertPosition] = 0;
            }

            insertPosition++;
            fast ++;
        }


    }
}
