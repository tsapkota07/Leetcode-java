package p0001_0100.p0001_two_sum;
import java.util.Arrays;

public class Runner
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] result1 = s.twoSum(nums1, target1);

        System.out.println("Test 1: " + Arrays.toString(result1));
    }
}
