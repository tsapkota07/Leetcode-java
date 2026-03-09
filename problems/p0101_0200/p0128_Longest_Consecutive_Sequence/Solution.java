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
        // Add all elements of nums into HashSet to remove duplicates and fast existence lookup.
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
/*
Pattern: HashSet, Membership lookup, start of sequence expansion

Core Idea:
Put all nums into a HashSet for expected O(1) lookup.
Only start counting when the number has no predecessor.
If we start counting, that means it is the start of a consecutive sequence.
For a consecutive sequence keep track of current longest and overall longest sequence.
Update it after every other consecutive sequence.

Why brute force fails:
A brute force would have to extend sequences starting from many numbers repeatedly. So, work will be repeated
and will be O(n^2) time.
Another method is to sort the numbers but that will take O(n log n) time which doesn't match the O(n) requirement.

Edge Cases:
- Empty array -> return 0
- Single element -> return 1
- Duplicates -> HashSet takes care of that
- Negative numbers -> works the same
- Multiple separate sequences -> returns the longest one.

Complexity:
-Time: O(n) expected
-Space: O(n)

Mistakes:
- Tried sorting first, which made it O(n logn) .
- Used predecessor logic incorrectly for counting instead of only checking the direct start of a sequence.
- Forgot that we should only expand from the beginning of a sequence.
- Tried to use HashMap previously which was unnecessary and inefficient.

Signal (how to recognize this pattern next time):
When the program involves:
- unsorted numbers
- consecutive values
- fast existence checking
- O(n) requirement.
*/
