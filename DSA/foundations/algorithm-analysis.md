# Algorithm Analysis

An algorithm is a step-by-step procedure that transforms input into output.

## Identify Clearly

- Input
- Output
- Preconditions (what's assumed true before)
- Postconditions (what must be true after)

## Primitive Operations

Each takes constant time:
- value assignment
- method call
- arithmetic operations
- comparison
- array indexing
- following object references
- return from method

Focus on dominant operations that grow with input size. Ignore constants and lower-order terms.

## Big O Notation

f(n) is O(g(n)) if f(n) grows no faster than g(n) for large n.

In practice: ignore constants and lower-order terms.

Example: 3n³ + 4n² + 5n + 6 → O(n³)

## Growth Hierarchy (slow to fast)

log n < n < n log n < n² < n³ < 2^n < n!

