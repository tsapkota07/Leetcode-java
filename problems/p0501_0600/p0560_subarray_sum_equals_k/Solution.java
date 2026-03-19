package p0501_0600.p0560_subarray_sum_equals_k;

import java.util.HashMap;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
Contiguous meaning subarray that has consecutive elements.
If [0,3,5,2,4] is an array, [0,3] or [3,5,2] is contiguous but [0,5] or [0,2,4] is not.
*/
// second try: reinforcement.
public class Solution{
    public int subarraySum (int[] nums, int k){
        // i wasn't able to do it the first time, and I watched a video.

        int sum = 0;     // runningSum of the array upto current index.
        int total = 0;

        HashMap <Integer, Integer> map = new HashMap<Integer, Integer> ();
        map.put (0,1); // this is in case the first number in nums equals k, and so sum - k = 0 should be in map.

        for (int num : nums){
            // calculate the sum.
             sum = sum + num;

             if (map.containsKey(sum-k)){
                 // multiple previous prefix sums may equal (sum - k),
                 // so we add the frequency instead of just 1.
                 total = total + map.get(sum-k);
             }

             // increment the value of sum if already present.
            // set value of sum to 1 if not present.
             map.put (sum, map.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}
/*
Pattern:
Prefix Sum and HashMap

Core Idea:
Store prefix sum, and it's frequency in a map
Iterate through the nums array
see if sum - k is already in the map
    if it is, update count
    add the frequency of sum-k to count. This is to account for zeros and negative numbers [IMPORTANT]
Exit out of the nums array
return count.

Why brute force fails:
- We must check each number against every other number, which is extremely inefficient.

Edge Cases:
- when there's all 0s and non-negative numbers (handled)
- When there's only one number (also handled)

Complexity:
Time: O(n)
Space: O(n)

Mistakes:
I tried to find sum in our map instead of sum-k.
I tried incrementing the count by 1 instead of adding the frequency of sum-k's value to the current count.

Signal (how to recognize this pattern next time):
- if the problem asks for subarrays
- num of ways/ total count.
- array may include negative numbers or zeros.
- a sum equal to some target that we know.

 */


// First Try: no brute force.
//public class Solution
//{
//    public int subarraySum(int[] nums, int k){
//
//        int count = 0;  // count = total number of valid subarrays
//        int runningSum = 0; // runningSum = prefix sum upto current index from 0.
//        HashMap< Integer, Integer > map = new HashMap<>(); // map -> stores prefixSum -> frequency
//
//        // We use running sum and Hashmap
//        // The running sum is the sum of all number from index 0 to the current index.
//        // We want to know if we have an earlier sum such that running sum - earlier sum == k.
//        // Rearranging this, want to know if earlier sum = running sum - k.
//        // So, the question becomes have we seen running sum - k = prefix sum before ?
//        // the map stores prefix sum -> frequency of the prefix sum.
//        // it remembers all previous running sums, so we can quickly check whether a previous sum exists
//        //  that forms a subarray of sum k.
//
//        map.put(0, 1);
//        // we put 0 inside the map as the first number might == k and want to include that in the subarray as well.
//        for (int num : nums)
//        {
//            // get the running sum upto the current number
//            runningSum += num;
//
//            // if map contains some previous sum then there exists a subarray that will equal k as we are
//            // just searching if previousSum = runningSum -k exists or not. Meaning, if running sum and some previous
//            // sum equal to k, they form a subarray sum.
//            if (map.containsKey(runningSum - k))
//            {
//                // this used to be count ++ previously.
//                // The reason we use map.get(runningSum - k) is because we want previous multiple frequencies to be
//                //  implemented in the current count as well
//                // Eg: [0,0,0,0]. If wer only get count++, if we're on the third number, even though possible subarrays
//                //      so far should  be 6 instead of 3 which is what we get if we do count ++ .
//                count = count + map.get(runningSum - k);
//            }
//
//
//            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
//        }
//
//        return count;
//
//    }
//
//}

/*
Pattern: Running Sum, HashMap

Core Idea:
Keep a running prefix sum.
if running sum - k has appeared before, then there exists a subarray ending with current index with sum k.
Store prefix sums in a hashmap as prefixSum -> frequency.

Why brute force fails:
// brute force has to check all the arrays and thus achieves O(n^2) time.

Edge Cases:
// Subarray starts at index 0 -> handled by map.put (0,1)
// negative numbers -> is handled by this.
// repeated prefix sums -> multiple valid subarrays end at the same index. This is key.

Complexity:
-Time: O(n)
-Space: O(n)

Mistakes:
- Trying two pointers/ sliding window even though negatives can exist.
- Forgetting to initialize map with 0->1.
- Storing prefix sums without counting valid subarrays first.

Signal (how to recognize this pattern next time):
- When the program asks for count of subarrays with a target sum, especially with negative integers, think
Prefix Sum + Hashmap.
*/


