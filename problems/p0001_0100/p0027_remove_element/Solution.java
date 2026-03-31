package p0001_0100.p0027_remove_element;
/*
Given an integer array [nums] and an integer [val], remove all occurrences of [val] in [nums] in-place.
The order of elements may be changed. Then, return the number of elements which are not equal to val.

Consider the number of elements in [nums] which are not equal to [val] be k, to get accepted, you need to do the
following things:
- Change the array [nums] such that the first k elements of [nums] contain the elements which are not equal
to [val]. The remaining elements of [nums] are not important as well as the size of [nums].
- Return k.
 */
public class Solution
{
    public int removeElement (int[] nums, int val) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int k = 0;

        if (nums.length == 0)   {
            return 0;
        }

        if (nums.length == 1){
            if (nums[0] == val){
                return 0;
            }
            else{
                return 1;
            }
        }
        while (leftPointer <= rightPointer){

            if (nums[leftPointer] == val) {
                nums[leftPointer] = nums[rightPointer];
                k ++;
                rightPointer --;
            }

            else {
                leftPointer ++;
            }

        }
        return nums.length - k;
    }
}
/*
Pattern:
Two Pointers

Core Idea:
say leftInteger = nums[leftPointer] and rightInteger = nums[rightPointer]
Compare leftPointer with value. If equal, swap leftInteger and rightInteger. Reduce rightPointer by 1.
If leftInteger isn't equal to value, increase leftPointer by 1.

Why brute force fails:
Brute force would have to compare against all elements and in place won't be possible.

Edge Cases:
When all the numbers are the same and equal to val.
When all the numbers are the same.
When we get an empty array.

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
Forgot to do an  else case and increase the left pointer.

Signal (how to recognize this pattern next time):
- When needed to do in place.
- When we might need to swap the elements within an array.
 */
