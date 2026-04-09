# Pattern: Two Pointers

## When to Use
- Problem asks you to find pairs or compare elements
- You need to modify an array in-place (without extra space)
- Array is sorted or can be sorted
- You'd otherwise use nested loops (O(n²))
- Problems with palindromes or subsequence matching

## Core Idea
Instead of nested loops checking everything against everything, use two pointers:
- Start from opposite ends (left and right)
- Move them toward each other based on a condition
- Or use fast/slow pointers for in-place operations

The key: the sorted property or structure lets you eliminate half the search space with each decision.
If sum is too small, move left pointer right (increase sum). If too big, move right pointer left (decrease sum).
No need to check everything.

## Two Main Approaches

### Approach 1: Opposite Pointers (Sorted Array)

```
left = 0
right = len(array) - 1

while left < right:
    current_sum = array[left] + array[right]
    
    if current_sum == target:
        return [left, right]
    
    if current_sum < target:
        left += 1  // need bigger sum, move left right
    else:
        right -= 1  // need smaller sum, move right left
```

### Approach 2: Fast/Slow Pointers (In-Place Modification)

```
slow = 0  // boundary of "valid" elements
fast = 0  // scan pointer

while fast < len(array):
    if array[fast] is valid:
        array[slow] = array[fast]
        slow += 1
    fast += 1

return slow  // new length after modifications
```

## Why This Works
Brute force nested loops: O(n²).
Two pointers: O(n) because you traverse each element at most once.
The trick is the sorted property or in-place structure lets you make smart moves.

## Complexity
- Time: O(n) — each element visited at most once
- Space: O(1) — in-place, no extra data structure

## Edge Cases
- Empty array → nothing to do
- Single element → can't make a pair
- All elements same → depends on the problem
- Duplicates at boundaries → be careful with pointer movement
- Off-by-one: does loop condition need `<` or `<=`?

## Mistakes to Avoid
- Forgetting to check pointer bounds before accessing array
- Moving the wrong pointer (or not moving at all = infinite loop)
- Moving only one pointer instead of the other
- Off-by-one at loop termination (should it be `left < right` or `left <= right`?)
- Modifying array while iterating with only one pointer

## Signal (How to Recognize)
- Problem says "find pair", "in-place", "merge", "partition"
- Array is sorted (or you can sort it)
- Brute force is clearly nested loops
- Space is tight (O(1) needed)
- You're working with opposite ends of array

