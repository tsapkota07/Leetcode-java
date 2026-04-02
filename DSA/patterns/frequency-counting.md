# Pattern: Frequency Counting

## When to Use
- The problem asks for "top K" or "most frequent" or "least frequent" elements
- You need to count how many times each element shows up
- You have to rank or group elements by their occurrence count

## Core Idea
Make a map that stores each number and how many times it appears. 
Then instead of sorting (which is slow O(n log n)), use a bucket trick: create buckets where bucket[i] holds all numbers that appear exactly i times.
Since the max frequency is n (array length), you only need n+1 buckets.
Then just go through buckets from highest frequency down and grab the top K.

## Step-by-Step

```
// Step 1: Count how many times each number appears
freq_map = {}
for each num in array:
    freq_map[num] = freq_map.get(num, 0) + 1

// Step 2: Put numbers into buckets by their frequency
// bucket[i] = list of numbers that appear exactly i times
buckets = array of empty lists, size = len(array) + 1
for each (num, count) in freq_map:
    buckets[count].append(num)

// Step 3: Go backwards through buckets and collect top K
result = []
for i from end of buckets down to 1:
    if buckets[i] has elements:
        add all elements from buckets[i] to result
        if we have K or more elements now:
            return first K elements
```

## Why This Works (The Trick)
If you sort by frequency, that's O(n log n). But you don't need to sort.
You know the frequencies are just numbers from 1 to n.
So you make buckets for each possible frequency and drop numbers into the right bucket.
Then you walk backwards (highest frequency first) and grab what you need. 
The whole thing is O(n).

## Complexity
- Time: O(n) — one pass to count, one pass to bucket, one pass to collect
- Space: O(n) — the map and the buckets

## Edge Cases
- What if all numbers appear the same number of times? → Just return any K of them
- What if K is bigger than the number of unique elements? → Return all unique elements
- What if K = 1 and there's a tie? → Return any one of the most frequent

## Problems I've Solved
- LC 0347 Top K Frequent Elements

## Mistakes to Avoid
- Sorting instead of using buckets (you'll TLE)
- Forgetting that multiple different numbers can have the same frequency
- Not checking if K > unique element count

## Signal (How to Recognize)
- Problem says "top K" or "most frequent" 
- You'd normally think: "count things, then sort, then pick top K"
- If time limit is tight, that's a clue you need the bucket trick instead

