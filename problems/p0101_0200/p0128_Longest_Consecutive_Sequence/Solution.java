package p0101_0200.p0128_Longest_Consecutive_Sequence;

import java.util.*;

/*
Given an unsorted array of integers, nums, return the length of the longest consecutive elements sequence.
Must write an algorithm that runs in O(n) time.
EG: Input  = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1,2,3,4]. Therefore it's length is 4.
 */
public class Solution
{
    public int longestConsecutive(int[] nums){
        if (nums == null  || nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return 1;
        }

        // Create a HashSet
        // Add all elements of nums into HashSet to remove duplicates.
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int length = 0;
        for (int num: set)
        {
            // KEY IDEA:
            /*
            If the number before isn't in the set, start counting.
            If the number before is in the set, skip it cause we wanna start from the beginning of the sequence.
             */
            if (!set.contains(num-1)){
                int currentNum = num;
                int currentLength = 1;

                // While the next number exists, keep on counting.
                while (set.contains(currentNum+1)){
                    currentNum += 1;
                    currentLength++;
                }
                // Calculate the max among the maximum so far and the currentMax.
                length = Math.max(length, currentLength);
            }
        }

        return length;
    }
}

