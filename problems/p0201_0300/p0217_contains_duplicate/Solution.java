package p0201_0300.p0217_contains_duplicate;

import java.util.HashMap;

/*
1.
Given some integer array nums, return true if any value appears twice in the array. Return false if every element is
distinct.
 */
public class Solution
{
    public Boolean containsDuplicate(int[] nums)
    {
        // Create a hash map that has elements in nums as the key and their frequency in nums as value.
        HashMap<Integer, Integer> frequencyMap = new HashMap< Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            // get the value for a key in our hashmap, if it exists. if the
            int value = frequencyMap.getOrDefault(nums[i], 0);

            // update the value for the current key.
            if (value <= 1) {
                frequencyMap.put(nums[i], value + 1);
            }

            // get the updated value again from our hashmap.
            value = frequencyMap.getOrDefault(nums[i], 0);

            // if value for a key is 2, meaning it is duplicate, return true.
            if (value > 1) {
                return true;
            }
        }
        return false;

    }
}

/*
Pattern: Hashing
Core Idea: Store into the hashmap, the numbers in the array as keys and their frequency as values. If the
    frequency is greater than 1, then return true without checking others as we already found a duplicate.
Why brute force fails: need to check each item against every other item to succeed.
Edge Cases: I had checked if the value was greater than 1 before incrementing it. So, i now increment the value
    at the end of each itertation.

Complexity:
-Time: O(n) worst case. O(1) best case.
-Space: O(n) worst case, O(1) average case. We keep updating the hashmap during program execution.

Mistakes: Don't check the values of stuff at the beginning before incrementing in the current iteration.

Signal (how to recognize this pattern next time): When we need to find the frequency of all items in a list.
*/