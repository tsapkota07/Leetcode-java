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

class Solution {
    public int[] twoSum (int[] nums, int target) {
        HashMap <Integer, Integer> complements = new HashMap <Integer, Integer>();

        for ( int i = 0; i < nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]);

            if (complementIndex != null) {
                return new int[] {i, complementIndex};
            }
            complements.put (target - nums[i], i);

        }

        return null;

    }


}
    /*
    {5, 2, 4}
    6

    HashMap  K -> V
    Key is (target - num} =
    We insert 1 into the map along with its index.
    1 -> 0
    Does the next value, 2,  match the key we have in our hashmap No.{(1,0)} So, we just insert 6-2 = 4 as the Key and 1 as the value.
    4 -> 1
    Does the next value, 4, match the key we have in our hashmap? Yes {(1,0), (4,1)}
    So return the current index, 2 and the index/value we find for the number 4 in our hashmpa,1 . So, our answer is {2,1} .


*/





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
