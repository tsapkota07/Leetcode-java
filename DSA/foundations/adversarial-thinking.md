# Adversarial Thinking

## Problem vs Algorithm

Problem: a task that needs solving.
Algorithm: a specific procedure that solves it.

One problem can have many algorithms.

## Lower Bound

The minimum amount of work any algorithm must perform to solve a problem.

If an algorithm does less work than the lower bound, it must be wrong.

## Adversary

A theoretical opponent that chooses inputs to make the algorithm work as hard as possible.

The adversary:
- chooses inputs strategically
- reveals minimal information
- forces worst-case behavior

## Worst Case vs Expected Case

**Worst Case**
- Deterministic guarantee
- Adversary forces the hardest possible input
- Example: all keys collide in a hash table

**Expected Case**
- Probabilistic analysis
- Assumes random input distribution
- Example: hash table operations average O(1)

Use adversarial thinking to prove lower bounds and analyze worst-case performance.

