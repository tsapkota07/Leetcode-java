package p0001_0100.p0011_container_with_most_water;
/*
You are given an integer array height of length n. There are n vertical lines such that the two endpoints
of the ith line are (i,0) and (i, height[i]).
Find two lines that together with the x-axis form a container such that the container contains the most water.
Return the maximum amount of water a container can store. Notice that you may not slant the container.
 */
public class Solution
{
    public int maxArea (int[] height) {
        // variables to store the current max, and two pointers left and right.
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;

        // loop until left and right pointers meet.
        while (left < right){

            // take the smaller one of the heights, then multiply it by the difference between right and left
            //pointer.
            // compare the result with max area, and store in max area, whichever is larger.
            if (height[left] < height[right]){
                maxarea = Math.max(maxarea, height[left] * (right - left));
                left ++;
            }
            else {
                maxarea = Math.max (maxarea, height[right] * (right - left));
                right --;
            }

        }
        return maxarea;

    }
}
/*
Pattern:
Two pointers.

Core Idea:
Set two pointers left and right. Set aside a variable, say max, to store the currentMax.
place left and right at the leftmost and rightmost part in the array.
Compare heights of line represented by left and right,
    if height[left] < height[right], then calculate height[left] * (right-left) to find the area.
    compare that area with max area, and put into max area, the larger of the two.

Why brute force fails:
We can try removing duplicates by shifting elements left on sorted height, but this is O(n^2) and too much work.

Edge Cases:
Empty array, single element, or all elements identical (not handled currently)

Complexity:
Time: O(n)
Space: O(1)

Mistakes:
- Not moving both the pointers correctly.

Signal (how to recognize this pattern next time):
sorted array + remove duplicates in place + keep order -> use fast/slow pointers.
 */
