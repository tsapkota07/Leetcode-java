package p0901_1000.p0977_squares_of_a_sorted_array;
/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number,
sorted in non-decreasing number.
 */
public class Solution
{
    public int[] sortedSquares (int[] nums) {
//        if (nums.length == 0){
//            return new int[] {};
//        }
//        if (nums.length == 1){
//            return new int[] {nums[0] * nums[0]};
//        }

        int [] result = new int[nums.length];

        int left = 0;
        int right = nums.length -1;
        for (int i = nums.length-1; i >= 0; i--){
            if (nums[left] * nums[left] > nums[right] * nums[right]){
                result[i] = nums[left] * nums[left];
                left ++;
            }
            else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }

        return result;

    }
}
/*
Pattern:
Two pointers, sorting.

Core Idea:
Create a new array the same size as nums.
Assign two pointers, left and right.
Iterate over result from the last index to the first.
    if nums[left] squared is more than nums[right] squared, put that into result[index] and increment left by 1.
    if nums[right] squared is more than nums[left] squared, put that into result[index] and decrement right by 1.

Why brute force fails:
Brute force asks us to sort the array, which takes O(n logn) in average case.

Edge Cases:
When there's no element or ony one element in the array.

Complexity:
Time: O(n)
Space: O(n)

Mistakes:
Didn't think of edge cases at first.
Started counting from nums.length instead of nums.length - 1.

Signal (how to recognize this pattern next time):
- When we need to compare elements multiple time while consistently decreasing or increasing their position.
 */
