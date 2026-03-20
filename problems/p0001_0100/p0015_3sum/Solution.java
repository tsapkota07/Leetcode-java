package p0001_0100.p0015_3sum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets nums[i], nums[j] and nums[k] such that
i != j, i != k, j !=k. and nums[i] + nums[j] + nums[k] = 0;
Notice that the solution must not contain duplicate triplets.
// */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort given array.
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3){
            return result;
        }

        if (nums.length == 3 && (nums[0] + nums[1] + nums[2] == 0)) {
            result.add(Arrays.asList(nums[0], nums[1], nums[2]));
            return result;
        }

        // select a element and go with it.
        // loop from the first to the second last for i as we still need at least 2 numbers after i
        // to form a triplet.
        for (int i = 0; i < nums.length-2; i ++ ){
            int left = i + 1;
            int right = nums.length - 1;
            int currentFixedNumber = nums[i];

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (left < right) {
                // skip duplicate fixed numbers;

                int total = nums[left] + nums[right] + currentFixedNumber;

                // if sum greater than 0, move right pointer one step left
                if (total > 0) {
                    right --;
                }
                // if sum is less than 0, move left pointer one step right
                else if (total < 0) {
                    left ++;
                }
                // if sum is equal to zero, add the values to our result.
                // in this case move both pointers.
                else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;

                    // check for duplicates in the consecutive array.
                    // duplicate towards the left side.
                    while (left < right && nums[left] == nums[left - 1]) left ++;

                    // duplicate towards the right
                    while (left < right && nums[right] == nums[right + 1]) right --;

                }

            }// end of while loop

        }// end of for loop.
        return result;
    } // end of threeSum class.
}
/*
Pattern:
Sorting plus two pointers

Core Idea:
Sort the nums array first.
Since there are three numbers, fix the first number.
    // check if the previous fixed number & current fixed number is the same starting from the 2nd iteration.
put left pointer as the 2nd number and right pointer at the last number initially
calculate total at this point.
    if total > 0, move right pointer one step left
    if total < 0, move left pointer one step right
    if total = 0, add it to our result and move both pointers.
        check for consecutive same values for left and right atp.

Why brute force fails:
- would've had to calculate every other possibility, resulting in O(n^3) time.

Edge Cases:
- When there is less than 3 elements in the array.
- When the  array has 3 elements but the total dont' sum up to 0.

Complexity:
Time: O(n^2)
Space: O(n)

Mistakes:
instead of checking for repeated values with a while loop for left and right duplicates i used an if statement.
put checking for duplicate for fixedValue inside the while loop rather than the just inside for loop at first.

Signal (how to recognize this pattern next time):
- if asked to find if the sum of given numbers equal a certain value.
- if given 3 numbers to iterate over, fix one of them at least.

 */





//// second try.
//public class Solution
//{
//    public List<List<Integer>> threeSum(int[] nums) {
//        // first of all, lets start with sorting the list.
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//
//        // let's try to use two pointers.
//        for (int i = 0; i < nums.length - 2; i++) // nums.length-1 is already occupied by the last pointer.
//        {
//            // if we get duplicate i, then skip.
//            if (i > 0 && nums[i] == nums[i - 1]){
//                continue;
//            }
//            int first = i + 1;
//            int last = nums.length - 1;
//
////            int indexedNum = nums[i];
//
//            while (first < last)
//            {
//                // calculate the total and save it to reduce time complexity.
//                int total = nums[first] + nums[last] + nums[i];
//
//                // if total is more than 0, reduce the last pointer to the one before.
//                if (total> 0)
//                {
//                    last--;
//                }
//
//                // if total is less than zero, move the first index one more
//                else if (total < 0)
//                {
//                    first++;
//                }
//                // if total is equal to zero, add it to our list.
//                else{
//                    result.add(Arrays.asList(nums[i], nums[first], nums[last]));
//                    first++;
//                    last--;
//                    // move on to the next pair.
//
//                    // check for duplicates.
//                    while (   first < last && nums[last] == nums[last + 1] ){
//                        last --;
//                        // if first is still in the range after increment
//                        // filter duplicate nums[last]
//                    }
//                    while (first < last && nums[first] == nums[first-1]) first++;
//                    // filter duplicate nums[first]
//                }
//            }
//
//        }
//
//        return result;
//    }
//
//}
/*
Pattern: Sorting + Two Sum
Core Idea:
Sort the array first.
Fix one of the three triplets fix nums[i].
use two pointer on the remaining part of the array.
left = i + 1 and right = nums.length -1;
Check the total:
- if total < 0, move left ++ to increase the total
- if total > 0, move right-- to decrease the total
- if total == 0, record the triplets, move both pointers and skip duplicates.


Why brute force fails: A brute force would check each i j and k triplet taking O(n^3) time.
Edge Cases:
- Array has fewer than 3 elements -> return empty list.
- Duplicate values -> skip duplicates for i j and k in each iteration.
- All zeros i.e. [0,0,0] must return [[0,0,0]] only once.
- If no valid triplets then return an empty list.
- Negative and positive numbers mixed together. Sorting solves this.

Complexity:
-Time: O(n^2)
-Space: O(n)

Mistakes:
- Moving only one pointer finding a valid triplets instead of both.
- Forgetting to filter duplicate values
- Using HashSet to remove duplicates rather than solve it with sorting.
- Trying to move index, left, and right all in one loop.
- Forgetting that the array must be sorted before using two sum.

Signal (how to recognize this pattern next time):
When the problem asks for triplets/ combinations of 3 values, especially with:
- target sum
- duplicate handling
- unsorted input

Sort first, fix one element, then solve the remaining with 2 pointers.
*/


// first try.
//
//public class Solution
//{
//    public List<List<Integer>> threeSum(int[] nums) {
//        // first of all, lets start with sorting the list.
//        Arrays.sort(nums);
////        List<List<Integer>> result = new ArrayList<>();
//        HashSet<List<Integer>> result = new HashSet<>();
//
//        // let's try to use two pointers.
//        for (int i = 0; i < nums.length - 1; i++)
//        {
//            int first = i + 1;
//            int last = nums.length - 1;
//
//            int indexedNum = nums[i];
//
//            while (first < last)
//            {
//                int firstNum = nums[first];
//                int lastNum = nums[last];
//
//                if (nums[i] + nums[first] + nums[last] == 0)
//                {
//                    result.add(Arrays.asList(nums[i], nums[first], nums[last]));
//                    first ++;
//                    last --;
//                }
//
//                if (nums[i] + nums[first] + nums[last] > 0)
//                {
//                    last--;
//                }
//
//                if (nums[i] + nums[last] + nums[first] < 0)
//                {
//                    first++;
//                }
//            }
//
//        }
//
//        return result.stream().collect(Collectors.toList());
//    }
//
//}
