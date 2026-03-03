package p0201_0300.p0238_Product_Of_Array_Except_Self;


/*
Given an integer array nums, return an answer such that answer[i] is the product of all the elements of nums
except nums[i].

The product of any prefix or suffix is guaranteed to fit in a  32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
 */

// just going to brute force this first before using prefix sum
// I haven't understood prefix sum yet.
public class Solution
{
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++){
            int product = 1;
            for (int j = 0; j < len; j++) {
                if (i != j){
                    product = product * nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}

/*
Pattern: Brute Force it.
Core Idea: Double for loops. initialize an array result[] with the same length as nums[]
    In each iteration, store the product of everything except the ith element in the result.
Edge Cases:

Complexity:
-Time: O(n^2)
-Space: O(1) Does not increase during run time after the initial compilation.

Mistakes: I did product =0 thinking it was prefix sum.
Signal (how to recognize this pattern next time): When you need to remove one element and work with everything else.
*/
