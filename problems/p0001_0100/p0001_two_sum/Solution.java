// Given an array of integers, nums and an integer target, return the indices of the two numbers such that
// they add up to the target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Input -> int[] nums, int target
// output -> indices of two numbers inside of nums, say i and j such that nums[i] + nums[j] = target
// preConditions: Each input would have exactly one solution. Meaning there can't be duplicate or no solutions.
//      : the values inside the array can't be repeated. Eg: if target is 4, we can't have [..., 2, 2...] inside the nums array.
// PostConditions: return indices i and j for nums[i] + nums[j] = target.








package p0001_0100.p0001_two_sum;

import java.util.HashMap;
// Reinforcement
class Solution{
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        // iterate over nums
            // see if nums[i] is in our map
                // if so, return [map.getValue(nums[i]), nums[i]]
            // store the nums[i] and it's index in our hashmap
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
/*
Pattern: HashMap

Core Idea:
For each nums[i], check if target - nums[i] is already in the map
If it is in the map then, return the value for target - nums[i], which is the index of that number in nums, and
    the current index.
Always put the current value and index in map.

Why brute force fails:
You have to use two for loops if you use brute force.

Edge Cases:
When the given array is empty, but this problem says that array won't be empty so don't worry about alldat.
When the array might have multiple solution, and the expected index might not match but this problem's test cases
    make sure that you get a unique solution.

Complexity:
Time: O(n)
Space: O(n)

Mistakes:
- Don't try to overcomplicate things.

Signal (how to recognize this pattern next time):
- You have to do constant lookups, use hashmaps.

*/




//
//class Solution {
//    public int[] twoSum (int[] nums, int target) {
//
//        /*
//        Before you understand hashmap, understand what a complement is.
//        if a + b are two numbers who equal the number target.
//        Then, b is the complement of a and a is the complement of b.
//        Also, we can have other complements such as c + d = target. To make it easy on us,
//        We say target's complement of a is b.Also, target's complement of b is a.
//        this means the same as a + b is target.
//         */
//
//        HashMap <Integer, Integer> complementMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            // Store the index of complement of the current number.
//            Integer indexOfComplement = complementMap.get(nums[i]);
//
//            // if the index is found, return the index of the current number + the index of it's complement.
//            if (indexOfComplement != null) {
//                int[] answer = {i, indexOfComplement};
//                return answer;
//            }
//
//            // if index is null, meaning the complement of the current number does not yet exist in the map, make sure
//            // to put the complement of this number into the mapping.
//            complementMap.put(target - nums[i], i);
//
//        }
//        return null;
//    }
//
//
//}
/*Thinking process:
HashMap  K -> V
Key is (target - num} =
We insert 1 into the map along with its index.
1 -> 0
Does the next value, 2,  match the key we have in our hashmap No.{(1,0)} So, we just insert 6-2 = 4 as the Key and 1 as the value.
4 -> 1
Does the next value, 4, match the key we have in our hashmap? Yes {(1,0), (4,1)}
So return the current index, 2 and the index/value we find for the number 4 in our hashmap,1 . So, our answer is {2,1} .

One more time, we try solving this using the Hashmap data structure. In each iteration we do the following:
- get the index of the complement of the current number from our mapping. return null if the complement of current number
does not yet exist.
- check if the complementIndex is null or not. If it is null, put the diference between the target and the current number
in nums along as a key and the current index as the value in our hashmap.
- if it is not null, just return the current index of the number along with the index of it's complement.

*/

//pattern used: Hashing
//Time complexity:
// O(1) best case as the first two numbers might add up to the target.
// O(n^2) worst case as we might have to deal with extreme hash collisions.
//      meaning, each get/put () becomes O(n).
// O (n) average case assuming that hash collisions aren't extreme.
//Space complexity: O(n)
//What trick made it work:We traded space for time. the mapping grows with each iteration wrt our array size.





//// first try: brute force
//public class Solution
//{
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length -1; i++){
//            for (int j = i + 1; j < nums.length; j++){
//                if (nums[i] + nums[j] == target){
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }
//
//}

/*
Thinking process: take a number and check if it's sum with every other number adds to the target. (n)
If the current number doesn't work with any other number to get the target, try every other one. (n)
 */

//pattern used: brute force
//Time complexity: O(n^2) worst case as two loops are used. O(1) best case as the first two numbers might give us the sum.
//Space complexity: O(1). We aren't using any extra space after the initial space.
//What trick made it work: just brute forced it.


//pattern used:
//Time complexity:
//Space complexity:
//What trick made it work: