package p0201_0300.p0238_product_of_array_except_self;


/*
Given an integer array nums, return an answer such that answer[i] is the product of all the elements of nums
except nums[i].

The product of any prefix or suffix is guaranteed to fit in a  32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
 */
// 3. reinforcement
public class Solution {
    public int[] productExceptSelf(int[] nums)
    {
        // we store a prefix and suffix array of products.
        // for any index i, unless its zero or last, product[i] = prefixArray[i-1] * suffixArray[i+1]
        // where we store prefix product in prefixArray and suffix product in suffix array.
        if (nums.length == 1){
            return new int[] {1};
        }

        if (nums.length == 2){
            return new int[]{nums[1],nums[0] };
        }

        // prefix is the product of elements before a certain index times the number in that index as well.
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int [nums.length];

        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length-1];

        // prefixProduct
        for (int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i - 1] * nums[i];
        }

        // suffixProduct
        for (int i = nums.length - 2; i >= 0; i --) {
            suffix[i] = nums[i] * suffix[i + 1];
        }

        result[0] = suffix[1];
        result[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length -1; i ++)
        {
            result[i] = prefix[i-1] * suffix[i + 1];
        }

        return result;

    }
}
/*
Pattern:
Prefix and Suffix Product.
For this solution, prefix[i] is the product of nums[0] through nums[i].
Similarly, suffix[i] is the product of nums[i] through nums[n-1].

Core Idea:
get the prefix and suffix product for each index. except:
    prefix[first] = nums[first]
    suffix[last] = nums[last]
then iterate from second to second-last element, for each element in range [second, second-last], do:
    result[index] = prefix[index-1] * suffix[index+1]
    NOTE: have some way to handle the first or last element while doing this.

Why brute force fails:
brute force will have to take O(n^2) time as it needs to iterate over all indexes, and multiply every other
index except the one we are on.

Edge Cases:
when nums.length = 1, resolve this by checking this at the beginning
when nums.length = 2, not a edge case but redundant to do all. resolve this with a simple return at beginning.

Complexity:
Time: O(n)
Space: O(n)

Mistakes:
- forgot the edge case for when nums.length == 1;

Signal (how to recognize this pattern next time):
- when each answer depends on all elements except the current one, think prefix/suffix products
 */



//// 2. prefix product.
//public class Solution {
//    public int[] productExceptSelf(int[] nums)
//    {
//        if (nums.length == 1) return new int[]{1};
//        // create an array to store the result, Create a prefix and Suffix product array as well.
//        int len = nums.length;
//        int[] res = new int[len];
//        int[] prefix = new int[len];
//        int[] suffix = new int[len];
//
//        // initialize the first position of prefix to be 1.
//        // Start from the second item of prefix to the last.
//        // Multiply the first position of prefix and nums and store the result in the second position of prefix.
//        // ... Multiply the ith position of prefix and nums and store the result in the (i+1)th position of prefix.
//        // --- Multiply the i-1th position of prefix and nums and store the result in the ith position of prefix.
//        prefix[0] = 1;
//        for (int i = 1; i < len; i++) {
//            prefix[i] = prefix[i-1] * nums[i-1];
//        }
//
//        // initialize the last item of suffix to be 1.
//        // Multiply the last position of suffix and nums and store the result in the second last position of suffix.
//        // ... Multiply the ith position of suffix and nums and store the result in the (i-1)th position of suffix.
//        // ... Multiply the i+1 th position of suffix and nums and store the result in the ith position of suffix.
//        // Start from the second last item of suffix to the last.
//        suffix[len-1] = 1;
//        for (int i = len-2; i >=0; i--)
//        {
//            suffix[i] = suffix[i+1] * nums[i+1];
//        }
//
//
//        // Multiply the corresponding position of prefix and suffix and put in the same position in result.
//        for (int i = 0; i < len; i++)
//        {
//            // multiply suffix and prefix items.
//            res[i] = prefix[i] * suffix[i];
//        }
//
//        return res;
//
//    }
//
//}





// 1. brute force
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
