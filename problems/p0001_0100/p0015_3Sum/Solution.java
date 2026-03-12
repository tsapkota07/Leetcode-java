package p0001_0100.p0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
Given an integer array nums, return all the triplets nums[i], nums[j] and nums[k] such that
i != j, i != k, j !=k. and nums[i] + nums[j] + nums[k] = 0;
Notice that the solution must not contain duplicate triplets.
 */
public class Solution
{
    public List<List<Integer>> threeSum(int[] nums) {
        // first of all, lets start with sorting the list.
        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<>();

        // let's try to use two pointers.
        for (int i = 0; i < nums.length - 2; i++) // nums.length-1 is already occupied by the last pointer.
        {
            int first = i + 1;
            int last = nums.length - 1;

//            int indexedNum = nums[i];

            while (first < last)
            {
//                int firstNum = nums[first];
//                int lastNum = nums[last];

                if (nums[i] + nums[first] + nums[last] == 0)
                {
                    result.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    first ++;
                    last --;
                }

                else if (nums[i] + nums[first] + nums[last] > 0)
                {
                    last--;
                }

//                if (nums[i] + nums[last] + nums[first] < 0)
                else
                {
                    first++;
                }
            }

        }

        return result.stream().collect(Collectors.toList());
    }

}
