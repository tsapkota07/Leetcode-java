package p0101_0200.p0128_longest_consecutive_sequence;

import java.util.*;

/*
Given an unsorted array of integers, nums, return the length of the longest consecutive elements sequence.
Must write an algorithm that runs in O(n) time.
EG: Input  = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1,2,3,4]. Therefore, it's length is 4.
 */

// 2. Reinforcement
public class Solution {
    public int longestConsecutive(int[] nums) {
        // edge cases
        if (nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return 1;
        }

        HashSet<Integer> set= new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int currentLongest = 0;
        int maximumLength = 0;
        int number = -1;

        // the idea, as far as i remember is to check if a number in the current index is the start of
        // a sequence or not.
        // If it is, then we see if the next element exists or not in our hashset
        // if it is not the start of a sequence, we skip it entirely and move to the next index.
        for (int i = 0; i < nums.length; i++){
            // check if some number - 1 exists in the set or not.
            // if it exists, continue to next index.
            number = nums[i];
            if (set.contains(number - 1)) {
                continue;
            }

            // if the current number is the start of a possible sequence, then we get to this part of the code.
            currentLongest = 1;
            while (true) {
                if (set.contains(number + 1) ){
                    currentLongest ++;
                    number ++;
                    continue;
                }

                maximumLength = Math.max (currentLongest, maximumLength);

                break;
            } // break out of the while loop

        }// end of for loop

        return maximumLength;

    }
}
/* Post Mortem
Pattern:
HashSet, which allows us an average of O(1) lookup.

Core Idea:
Store all elements of nums in a HashSet
Iterate through nums, number = nums[i]
    if number - 1 is in or hashset, move to the next index
    if number - 1 isn't in our hashset, see if number + 1 is
        if number + 1 is in hashset, increment currentLength and check for next number after this.
    compare currentLongestLength vs our previous maximum and store the result in maximum.
return maximum.

Why brute force fails:
Brute force would have had to first sort the array, then iterate through elements in that array.
Didn't really implement brute force so don't know how we would go about it.

Edge Cases:
When given array has no integers or only one integer.

Complexity:
Time: O(n) average.
    To elaborate on this, even though we have a while loop inside our for loop, the total runtime of that
    while loop is still O(n) across all iterations of for loop. This is because we skip a number if it's not
    a start of a sequence in our for loop and always start from the start of a possible sequence in our while loop.
    I say possible sequence because we might even see a standalone number with no number-- or number++ in nums.
Space: O(n)

Mistakes:
When iterating the array, I accidentally set the range (0, nums.length) instead of (0,numsLength-1) which
gave me an index out of bounds exception.

Signal (how to recognize this pattern next time):
When we need O(1) lookup, we use hashset, especially when it's not a key-value pair.

 */

//
//// 1. First Try
//public class Solution
//{
//    public int longestConsecutive(int[] nums){
//        if (nums == null  || nums.length == 0){
//            return 0;
//        }
//
//        if (nums.length == 1){
//            return 1;
//        }
//
//        // Create a HashSet
//        // Add all elements of nums into HashSet to remove duplicates and fast existence lookup.
//        Set<Integer> set = new HashSet<>();
//        for (int num: nums) {
//            set.add(num);
//        }
//
//        int length = 0;
//        for (int num: set)
//        {
//            // KEY IDEA:
//            /*
//            If the number before isn't in the set, start counting.
//            If the number before is in the set, skip it cause we wanna start from the beginning of the sequence.
//             */
//            if (!set.contains(num-1)){
//                int currentNum = num;
//                int currentLength = 1;
//
//                // While the next number exists, keep on counting.
//                while (set.contains(currentNum+1)){
//                    currentNum += 1;
//                    currentLength++;
//                }
//                // Calculate the max among the maximum so far and the currentMax.
//                length = Math.max(length, currentLength);
//            }
//        }
//
//        return length;
//    }
//}
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
