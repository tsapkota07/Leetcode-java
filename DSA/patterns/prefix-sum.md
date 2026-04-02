# Pattern: Prefix Sum

## When to Use
- Problem asks for "sum of elements from index i to j"
- You need to find subarrays with a specific sum
- Array has negative numbers or zeros (sliding window doesn't work)
- You'd need to recalculate sums repeatedly (optimize with prefix)
- Count how many subarrays equal target

## Core Idea
Instead of calculating sum(i to j) every time (expensive), precompute all running sums.
Then any range sum is just: prefix[j] - prefix[i-1].
If you also track a map of previous prefix sums, you can find subarrays with target sum in one pass.

The trick with negatives: if running_sum - k appeared before, then there's a subarray ending here with sum k.

## Step-by-Step

### For Range Queries

```
// Precompute prefix sums once
prefix = [0]
for each num in array:
    prefix.append(prefix[-1] + num)

// Now any range sum is instant
def range_sum(i, j):
    return prefix[j+1] - prefix[i]  // sum from index i to j inclusive
```

### For Finding Subarrays With Target Sum (Handles Negatives)

```
sum_freq = {0: 1}  // map of prefix_sum -> how many times we've seen it
count = 0
running_sum = 0

for each num in array:
    running_sum += num
    
    complement = running_sum - k
    
    // If we've seen this complement before, there's a subarray with sum k
    if complement in sum_freq:
        count += sum_freq[complement]  // add frequency, not just 1
    
    // Remember this prefix sum
    sum_freq[running_sum] = sum_freq.get(running_sum, 0) + 1

return count
```

## Why This Works (The Magic)

Why can't you use sliding window? Because of negatives.
If you have [1, -1, 1, -1] and target 0, a sliding window that shrinks when sum is 0 will miss valid subarrays.

But with prefix sum + map:
- Keep running total
- For each position, ask: "have I seen (running_sum - k) before?"
- If yes, the gap between then and now is a subarray with sum k
- Count frequency because multiple positions might have same prefix sum (multiple valid subarrays)

Example: [1, 1, 1], k = 2
- At index 0: running_sum = 1, look for 1-2 = -1 (no), map = {0:1, 1:1}
- At index 1: running_sum = 2, look for 2-2 = 0 (yes! found 1), count += 1, map = {0:1, 1:1, 2:1}
- At index 2: running_sum = 3, look for 3-2 = 1 (yes! found 1), count += 1, map = {0:1, 1:1, 2:1, 3:1}
- Answer: 2 subarrays (indices 0-1 and 1-2)

## Complexity
- Time: O(n) — one pass, map operations are O(1) average
- Space: O(n) — the prefix array or map can be size n

## Edge Cases
- All zeros → many subarrays with same sum
- Negative numbers → essential; this pattern handles them
- Single element → if it equals k, count is 1
- Target unreachable → count stays 0
- Same prefix sum at different positions → that's the point! Multiple valid subarrays

## Problems I've Solved
- LC 0238 Product of Array Except Self — prefix/suffix products (no target, but similar idea)
- LC 0560 Subarray Sum Equals K — count subarrays with sum = k

## Mistakes to Avoid
- Forgetting to initialize map with `{0: 1}` — without this, subarrays starting at index 0 are missed
- Looking up prefix_sum instead of (prefix_sum - k)
- Adding 1 to count instead of the frequency of the complement
- Not accounting for duplicate prefix sums
- Using sliding window on arrays with negatives

## Signal (How to Recognize)
- Problem says "subarrays", "sum from", "range query", or "count of subarrays"
- Target sum is specified
- Array can have negatives or zeros
- Sliding window feels like it should work but doesn't

