package p0301_0400.p0347_Top_K_Frequent_Elements;

import java.util.*;

/*
Given an integer array nums, and an integer k, return the k most frequent elements. You may return the answer
in any order.

Constraints:
- 1 <= nums.length <= 10^5 AND -10^4 <= nums[i] <= 10^4
- k is in the range of (1, no of unique elements in nums)
- it is guaranteed that the answer is unique.
 */
public class Solution
{
    public int[] topKFrequent(int[] nums, int k)
    {
        // store the numbers in nums and their frequency
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // so, numbers are stored as num -> frequency pair.
        // We want to store the numbers in order of frequency and get the numbers with the top k frequency.

        //
        int[] intArray = map.entrySet().stream()
                .mapToInt(Integer::intValue)
                .toArray();

        // Sort the list.
        Arrays.sort(intArray);

        // convert firstK to an array of int and then return.
        return Arrays.copyOf(intArray, k);
    }

}
