package p0101_0200.p0167_Two_Sum_II_Input_Array_Is_Sorted;

import java.util.HashMap;

/*
Given a 1-indexed array of integers, numbers, that is already sorted in non-decreasing order, find two numbers such
that they add up to a specific, target, number. Let these two numbers be numbers[index_1] and numbers[index_2] where
1 <= index_1 < index_2< <= numbers.length

Return the indices of the two numbers index_1 and index_2, each incremented by one, as an integer array [index_1, index2]
of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must only use constant extra space.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target)
    {
        // we use two pointers here.
        // There is guaranteed to be a solution, so no need to take precaution for the case of no solution.
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];


        while (left < right)
        {
            int sum = numbers[left] + numbers[right];

            System.out.println("nums[left] = " + numbers[left] + ", nums[right] = " + numbers[right]);
            // if left plus right is target, we found our match.
            if (sum == target)
            {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }

            // since the array is sorted, and sum < target, the only way to increase our sum is :
            if (sum < target)
            {
                left++;    // we move the left pointer to the next index.
            }

            if (sum> target)
            {
                // if the sum is too large, the only way to decrease our sum, done by moving right pointer one step left
                right--;
            }
        }

        return result;
    }

}

/*
Pattern: Two Pointers
Core Idea:
Since the array is sorted, we can place one pointer at the left most and one at the right most item in the array.
Then we compute the sum numbers[left] + numbers[right] = sum.
- if sum == numbers[left] + numbers[right], return [left+1, right+1]
- if sum > numbers[left] + numbers[right], we decrease the sum, to do this, move right one step to the left.
- if sum < numbers[left] + numbers[right], we increase the sum, to do this, move left one step to the right.
Because the array is sorted, moving the pointers changes the sum predictably, allowing us to find the correct
pair in one pass.

Why brute force fails:
IN brute force, we have to check every pair(i,j) to see if nums[i] + nums[j] == target or not for all i < j.
This takes two nested loops and thus gives us O(n^2) time.

Edge Cases:
array length = 2, we handle that by checking if nums[left] + nums[right] at the beginning of our while loop.
negative numbers still work
duplicate values are allowed but indices must be consistest. So that solves this.
The program gurantees exactly one solution.

Complexity:
-Time: O(n)
-Space: O(1)

Mistakes:
- trying to use hashmaps even though constant space is emphasized.
- forgetting the array is sorted and not using two pointer.
- recomputing nums[left] and nums[right] multiple times instead of putting them in a variable.
- forgetting the problem expects left+1, and right+1. This is called one indexed. from 1 to n instead of 0->n+1

Signal (how to recognize this pattern next time):
*/