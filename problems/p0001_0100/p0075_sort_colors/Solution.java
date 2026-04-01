package p0001_0100.p0075_sort_colors;
/*
Given an array [nums] with [n] objects colored red, white, or blue, sort them in place so that
the objects of the same color are adjacent, with the color in the order red, white, and blue.

We will use the integers [0], [1], and [2] to represent the color red, white, and blue respectively.
You must solve this problem without using the library's sort function.

Constraints:
- n == nums.length
- 1 <= n <= 300
- nums[i] is either 0, 1, or 2.
 */
public class Solution
{
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        int tmp = -1;

        do
        {
            if (nums[i] == 0)
            {
                tmp = nums[red];
                nums[red] = nums[i];
                nums[i] = nums[red];
                red++;
                i++;
            }
            else if (nums[i] == 2)
            {
                nums[i] = nums[blue];
                nums[blue] = 2;
                blue--;
            }
            else if (nums[i] == 1)
            {
                tmp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = tmp;
            }
        } while (i < blue);
    }
}
