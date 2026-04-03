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
                tmp = nums[i];
                nums[i] = nums[red];
                nums[red] = tmp;
                red++;
                i++;
            }
            else if (nums[i] == 2)
            {
                tmp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = tmp;
                blue--;
            }
            else if (nums[i] == 1)
            {
                i++;
            }
        } while (i <= blue);
    }
}
/*
Pattern:
Two pointers

Core Idea:
one points at the place where the next red should go, initially at 0.
and the other points at the place where the next blue should go, initially at the last, n-1.
We then iterate until we

Why brute force fails:
Brute force would have to probably scan the array and keep track of the no of elements. Then populate a new array.

Edge Cases:
When there is only one element in the array, or it is already sorted.

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
I overcomplicated the part where nums[i] == 1, leading me to not being able to think properly for red and blue cases.

Signal (how to recognize this pattern next time):
- If needed to do in place sorting or something that involves swapping elements in an array.
 */
