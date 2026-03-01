package p0301_0400.p0349_Intersection_Of_Two_Arrays;


import java.util.HashMap;
import java.util.HashSet;

/*
Given an integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.
 */
public class Solution
{
    public int[] intersection(int[] nums1, int[] nums2) {

        // get the frequency of each item in the first array.
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        // if a number already has its key in the map, increase the value by 1.
        // if a number doesn't have a key in the map, decrease the value by 1.
        for (int i = 0; i < nums1.length; i++) {
//            if (frequencyMap.getOrDefault(nums1[i], 0) > 0)
//            {
//                frequencyMap.put(nums1[i], frequencyMap.getOrDefault(nums1[i], 0) + 1);
//            }
//            else
//            {
                frequencyMap.put(nums1[i], 1);
//            }
        }


        HashSet<Integer> intersectionSet = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (frequencyMap.containsKey(nums2[i])) {
                intersectionSet.add(nums2[i]);
            }
        }

        return  intersectionSet.stream().mapToInt(Integer::intValue).toArray();

    }
}
/*
Pattern: HashMap and HashSet. I understood HashSet to just be an extendable array that doesn't allow duplicates
    atp but idk if its correct.
Core Idea: Hash Map and Hash Set
Why brute force fails: I don't really know if this is brute force or optimal. I'll probably learn better algorithms
    along the way. For now this is fine.
Edge Cases: When none of the arrays have any contents, this might be just wasted work. So, i'll just put a tester
    at the beginning.

Complexity:
-Time: O(n) worst case. Assuming that hashset insertion and get is O(1). O(n) best case as well as we must put all
    the values of nums1 into a Hashmap anyways.
-Space: O(n). Changes within the program execution.

Mistakes: None that i have recognized so far.

Signal (how to recognize this pattern next time):  If it asks for intersection, we can use this.
*/

