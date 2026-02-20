package p0001_0100.p0001_two_sum;
import java.util.Arrays;

public class Runner
{
    public static void main(String[] args)
    {
        p0001_0100.p0001_two_sum.Solution s = new p0001_0100.p0001_two_sum.Solution();

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {2, 0, 1, 4};
        int target1 = 9;
        int target2 = 6;

        int[] result1 = s.twoSum(nums1, target1);
        int[] result2 = s.twoSum(nums2, target2);
        System.out.println("Test 1: " + Arrays.toString(result1));
        System.out.println("Test 2: " + Arrays.toString(result2));
    }
}
