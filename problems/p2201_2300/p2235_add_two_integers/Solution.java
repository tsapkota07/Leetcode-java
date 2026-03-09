package p2201_2300.p2235_add_two_integers;

class Solution {

    /*
     * Problem: 2235 - Add Two Integers
     * Pattern: Basic Arithmetic
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */

    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    // Local testing only (optional)
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sum(12, 5));   // Expected: 17
        System.out.println(s.sum(-10, 4));  // Expected: -6
    }
}