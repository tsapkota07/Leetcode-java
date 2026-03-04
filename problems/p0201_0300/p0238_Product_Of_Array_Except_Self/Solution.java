package p0201_0300.p0238_Product_Of_Array_Except_Self;


public class Solution {
    public int[] productExceptSelf(int[] nums)
    {
        if (nums.length == 1) return new int[]{1};
        // create an array to store the result, Create a prefix and Suffix product array as well.
        int len = nums.length;
        int[] res = new int[len];
        int[] prefix = new int[len];
        int[] suffix = new int[len];

        // initialize the first position of prefix to be 1.
        // Start from the second item of prefix to the last.
        // Multiply the first position of prefix and nums and store the result in the second position of prefix.
        // ... Multiply the ith position of prefix and nums and store the result in the (i+1)th position of prefix.
        // --- Multiply the i-1th position of prefix and nums and store the result in the ith position of prefix.
        prefix[0] = 1;
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        // initialize the last item of suffix to be 1.
        // Multiply the last position of suffix and nums and store the result in the second last position of suffix.
        // ... Multiply the ith position of suffix and nums and store the result in the (i-1)th position of suffix.
        // ... Multiply the i+1 th position of suffix and nums and store the result in the ith position of suffix.
        // Start from the second last item of suffix to the last.
        suffix[len-1] = 1;
        for (int i = len-2; i >=0; i--)
        {
            suffix[i] = suffix[i+1] * nums[i+1];
        }


        // Multiply the corresponding position of prefix and suffix and put in the same position in result. 
        for (int i = 0; i < len; i++)
        {
            // multiply suffix and prefix items.
            res[i] = prefix[i] * suffix[i];
        }

        return res;

    }

}

/*
Given an integer array nums, return an answer such that answer[i] is the product of all the elements of nums
except nums[i].

The product of any prefix or suffix is guaranteed to fit in a  32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
 */

// just going to brute force this first before using prefix sum
// I haven't understood prefix sum yet.
//public class Solution
//{
//    public int[] productExceptSelf(int[] nums) {
//        int len = nums.length;
//        int[] result = new int[len];
//
//        for (int i = 0; i < len; i++){
//            int product = 1;
//            for (int j = 0; j < len; j++) {
//                if (i != j){
//                    product = product * nums[j];
//                }
//            }
//            result[i] = product;
//        }
//        return result;
//    }
//}

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
