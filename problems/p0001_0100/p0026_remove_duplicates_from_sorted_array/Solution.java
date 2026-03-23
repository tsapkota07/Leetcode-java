package p0001_0100.p0026_remove_duplicates_from_sorted_array;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that
each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k, After removing duplicates, return the number
of unique elements k.

The first k elements of nums should contain the unique elements in sorted order. The remaining elements beyond
k-1 can be ignored.

Custom judge:
The judge will test your solution with the following code:
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 1;

        while (fast < nums.length){
            if (nums[fast] == nums[fast-1]){
                fast++;
            }
            else{
                nums[slow+1] = nums[fast];
                fast ++;
                slow++;
            }

        }

        return slow + 1;
    }
}
/*

Pattern:
Two pointers plus array

Core Idea:
Keep a fast and slow pointer.
Check if fast pointer and it's preceding value are the same
    if so, move fast ++
    if not, put the value in slow, increment both slow and fast at this point.
return slow + 1 as that's the no of items.

Why brute force fails:
requires shifting elements repeatedly (O(n^2))

Edge Cases:
Empty array or all elements identical- handled.

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
Forgetting to move slow pointer or returning wrong k

Signal (how to recognize this pattern next time):
Sorted array + in-place duplicate removal → use fast/slow pointers

 */
