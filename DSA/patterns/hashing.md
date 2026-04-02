# Pattern: Hashing

## When to Use
- The problem asks you to "find", "check if exists", or "is there a duplicate"
- You'd normally need to loop back through data to check membership
- You need O(1) lookups instead of O(n) searches
- You need to track which elements you've seen

## Core Idea
Instead of searching through your array every time (slow O(n)), put things in a HashMap or HashSet as you go.
Then checking "did I see this before?" becomes instant O(1) lookup.

The trick is: for problems like Two Sum, don't look for the number itself.
Look for its complement. If I'm at number X and I need target sum, I ask: "have I already seen target - X?"
If yes, I found my pair. If no, I remember this X for later.

## Step-by-Step (Two Sum Example)

```
// We need two numbers that add up to target
map = {}  // stores: number -> index
for current index, current number in array:
    complement = target - current_number
    
    // Check if we've seen the complement before
    if complement exists in map:
        return [map[complement], current_index]
    
    // Remember this number for future checks
    map[current_number] = current_index
```

## Why This Works
Brute force: check every pair = O(n²).
Smart: for each number, ask "have I seen its complement?" = O(n).
The map lookup is the key. It's instant instead of searching.

## Complexity
- Time: O(n) — one pass, each operation is O(1) on average
- Space: O(n) — the map can grow to size n

## Edge Cases
- Empty array → return nothing
- Single element → can't make a pair
- Duplicates → when to use HashMap (track index) vs HashSet (just track existence)
- Negative numbers → just work normally, complement can be negative

## Problems I've Solved
- LC 0001 Two Sum — find two numbers that add to target
- LC 0217 Contains Duplicate — just check if you've seen it before
- LC 0242 Valid Anagram — count character frequencies
- LC 0349 Intersection of Two Arrays — track which numbers appeared

## Mistakes to Avoid
- Forgetting to check if complement exists before accessing the map
- Using the wrong data structure: HashMap for index, HashSet for just existence
- Storing values in map when you really need frequency counts
- Trying to use this when you actually need to count occurrences (use frequency counting instead)

## Signal (How to Recognize)
- Problem says "find a pair", "check if exists", "is there a duplicate"
- You think: "I'd need nested loops to check"
- You have time constraints that rule out brute force
- You need fast membership checks

