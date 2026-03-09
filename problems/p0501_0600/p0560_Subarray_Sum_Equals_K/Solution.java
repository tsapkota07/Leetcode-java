package p0501_0600.p0560_Subarray_Sum_Equals_K;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
Contiguous meaning subarray that has consecutive elements.
If [0,3,5,2,4] is an array, [0,3] or [3,5,2] is contiguous but [0,5] or [0,2,4] is not.
 */
public class Solution
{
    public int subarraySum(int[] nums, int k){

        // Will learn and do it later.
        int number = 0;
        for (int index = 0; index < nums.length; index++){
            if (nums[index] == k) {
                number++;
                continue;
            }

            // Wrong Code.
            if (nums[index+1] + nums[index] == k){
                number ++;
                break;
            }
            else if (nums[index +1] + nums[index] < k){
                nums[index] = nums[index-1] + nums[index];
            }
            else{
                break;
            }
        }

        return number;

    }

}


