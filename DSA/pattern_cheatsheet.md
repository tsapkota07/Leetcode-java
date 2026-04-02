# Patterns Cheatsheet

Quick reference for all patterns. See full files in `patterns/` for details.

---

## Hashing

**What:** Use HashMap or HashSet for O(1) lookups instead of O(n) searches.

**When:** Find pairs, detect duplicates, track membership, need instant lookups.

**Key Trick:** For each element, check if its complement (target - element) exists. Trade space for speed.

**Time:** O(n) | **Space:** O(n)

**Example:** Two Sum, Contains Duplicate

---

## Frequency Counting

**What:** Count occurrences of each element, rank by frequency using buckets.

**When:** Top K problems, most/least frequent, need to rank by count.

**Key Trick:** Instead of sorting O(n log n), use bucket sort O(n) where bucket[i] = elements appearing i times.

**Time:** O(n) | **Space:** O(n)

**Example:** Top K Frequent Elements

---

## Two Pointers

**What:** Move two pointers (opposite ends or fast/slow) through array.

**When:** Sorted arrays, in-place modifications, find pairs, palindromes.

**Key Trick:** Sorted property lets you eliminate half the search space. If sum too small, move left pointer right. If too big, move right pointer left.

**Time:** O(n) | **Space:** O(1)

**Example:** Container With Most Water, 3Sum, Remove Duplicates, Move Zeroes

---

## Prefix Sum

**What:** Precompute running sums. Use HashMap to find subarrays with target sum.

**When:** Range sum queries, count subarrays with specific sum, array has negatives/zeros.

**Key Trick:** If (running_sum - k) appeared before, there's a subarray ending here with sum k. Track frequency of prefix sums.

**Time:** O(n) | **Space:** O(n)

**Example:** Subarray Sum Equals K, Product of Array Except Self

---

## How to Recognize

- **Hashing:** "find pair", "duplicates", "check if exists"
- **Frequency:** "top K", "most frequent", "rank by count"
- **Two Pointers:** "sorted array", "in-place", "two numbers"
- **Prefix Sum:** "subarrays", "sum from", "range", "has negatives"

