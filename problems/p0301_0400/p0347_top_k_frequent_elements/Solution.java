package p0301_0400.p0347_top_k_frequent_elements;

import java.util.*;

/*
Given an integer array nums, and an integer k, return the k most frequent elements. You may return the answer
in any order.

Constraints:
- 1 <= nums.length <= 10^5 AND -10^4 <= nums[i] <= 10^4
- k is in the range of (1, no of unique elements in nums)
- it is guaranteed that the answer is unique.
 */


//Reinforcement
public class Solution
{
    public int[] topKFrequent(int[] nums, int k)
    {
        // store the numbers and their frequency as a hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            // put previous value + 1 if a item already exists in the map.
            // put frequency as 1 if a item doesn't exit.
            map.put (num, map.getOrDefault(num,0) + 1);
        }

        // now in a list(bucket), store frequency -> elements.
        // for a specific frequency, many elements can have the same frequency.
        // Make a array of empty lists. Note that each element is an uninitialized list that's meant to hold Integers.
        List<Integer> list[] = new List[nums.length+1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int element = entry.getKey();
            int frequency = entry.getValue();

            // if the list for the current frequency doesn't yet exist,
            if (list[frequency] == null)
            {
                list[frequency] = new ArrayList<>();
            }

            // add the corresponding element to each frequency
            list[frequency].add(element);
        }
        // At this point, in our bucket, numbers are elements are stored in the index of their corresponding frequency
        // Eg: bucket[1] has elements that occured only once, bucket[2] has elements that occured twice and so on.

        int ans[] = new int[k];// ans to store k elements as we need top k elements.
        int counter = 0;
        int frequency = nums.length;
        // Get the top k elements from our bucket.
        while (counter < k) {
            // Start from the highest frequency.

            // if current frequency has no elements, move on to the next.
            if (list[frequency] == null){
                frequency--;
                continue;
            }

            for (int number : list[frequency]) {
                ans[counter] = number;
                counter ++;
                if (counter == k) {
                    break;
                }
            }
            frequency--;
        }
        return ans;
    }
}
/*

Pattern:
Buckets, HashMap,

Core Idea:
Store all elements as key value pair, for element -> frequency in a map.
Store all elements as frequency-> elements in a bucket of List of Integers.
Establish a result list with size k.
Iterate from the top of the bucket until all k results are filled in for our result.

Why brute force fails:
Brute force would have to recount and re allocate each frequency separately and finally sort them.

Edge Cases:
When for a certain frequency, one item is supposed to go into a bucket but another isn't.

Complexity:
Time: O(n)
Space: O(n)

Mistakes:
Forgot java syntax for dealing with buckets and looping over elements of a map.

Signal (how to recognize this pattern next time):
If we have an idea of the number of elements we want + want some specific first or last few values, use
a bucket. 

 */


//
//public class Solution
//{
//    public int[] topKFrequent(int[] nums, int k)
//    {
//        // store the numbers in nums and their frequency as a hashap
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int num : nums)
//        {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        // We want to store the numbers in order of frequency and get the numbers with the top k frequency.
//        // We use a bucket to store the frequency and the numbers that have that frequency.
//
//        // initialize a bucket with size nums.length + 1. to store frequency and numbers in nums with their
//        //      appropriate frequency. for eg, if nums: {1,1,2} bucket[0] = null, bucket[1] = [2], bucket[2] = [1],
//        //      bucket[3] = null. Note that bucket has length of nums + 1.
//        // Each element in the bucket is a List<Integer> object.
//        // so, a bucket would visually look like:
//        // bucket
//        // |----bucket[0]
//        // |----bucket[1]
//        // |----bucket[2]
//        // |-----
//        // |----bucket[n]
//        // and each slot can hold a List<Integer> object. Meaning, it's a list of integers.
//        List<Integer>[] bucket = new ArrayList[nums.length + 1];
//
//        // Put all the elements from our hashmap into the bucket with frequency -> numbers that match that frequency.
//        // put numbers into buckets.
//        for (Map.Entry<Integer, Integer> entry : map.entrySet())
//        {
//            // store number and frequency for each map entry.
//            int number = entry.getKey();
//            int frequency = entry.getValue();
//
//            // Remember, each bucket entry is an uninitialized List<Integer> object.
//            // Thus, we can't just add numbers to each bucket entry without initializing it first.
//            // So, we initialize it to a new ArrayList<>() so that it's size can change during execution if need be.
//            if (bucket[frequency] == null)
//            {
//                bucket[frequency] = new ArrayList<>();
//            }
//
//            // Add the number to each frequency entry.
//            bucket[frequency].add(number);
//
//        }
//
//        int[] ans = new int[k];
//        int index = 0;
//        // Extract from bucket until we get k elements.
//        // Start from the highest frequency as we want the top k highest.
//        // iterate from bucket[n] to bucket[0].
//        // Break as soon as we get index == k.
//
//
//        for (int freq = nums.length; (index < k) && (freq >= 1); freq--)
//        {
//            // check if the bucket has any elements.
//            // If it has any elements, we've initialized it before and put a corresponding number, so it shouldn't be null.
//            if (bucket[freq] == null)
//            {
//                continue;
//            }
//
//            // If we get to this point, it means bucket[freq] isn't null
//            // Check all the elements in bucket[freq].
//            // We check the index aftee each number in a specific bucket[freq]
//            // This ensures that we put exactly k elements in our ans array and not go out of bounds.
//            for (int num : bucket[freq])
//            {
//                ans[index++] = num;
//                if (index == k)
//                {
//                    break;
//                }
//            }
//        }
//
//        return ans;
//
//    }
//}
/*
Pattern: Bucket, Hashmap
Core Idea: Store num-> frequency in hashmap. Store frequency-> num in bucket. Get the elements with top k frequency
    from the bucket.
Why brute force fails: Even with just hashmap, brute force takes too long.
Edge Cases: When we have the same frequency for many items and certain items with the same frequency don't get added
    to a particular bucket[frequency]

Complexity:
-Time: O(n)
-Space: O(n)

Mistakes: Tried to use only hashmap and didn't really understand bucket at this point.

Signal (how to recognize this pattern next time): If we want the top something numbers from a finite and small range,
    use a bucket.
*/

/*
NOTE: Explaination about the Time Complexity.
Worst Case, Realistically, we have: O(n).
This is because we have:
- Build Frequency Map -> O(n)
- Fill Buckets -> O(n)
- Extract Elements -> O(n)
So, a total of 3O(n) = O(n).

But, Theoretically, since we're using a hashmap, just the frequency map should be O(n^2).
But, we assume it to be O(1) which is due to uniform hash distribution, we realistically get O(1).
If we go strict theoretical it's going to be O(n^2) for time complexity.
 */

