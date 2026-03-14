# LeetCode Java Practice

This repository contains my practice for **Data Structures and Algorithms using Java**.

The goal is to solve LeetCode problems in a structured and repeatable environment instead of solving them only on the website.

---
## Using This Repository

If you want to use this setup for practicing LeetCode locally:

```bash
git clone https://github.com/tsapkota07/Leetcode-java.git
cd Leetcode-java
source scripts/aliases.sh
```

You can then run problems from the terminal:

```bash
lc 1
lc 1 open
lc 1 list
```

---

## Repository Structure

Problems are grouped in folders of **100 problems each**.

```
problems/
  p0001_0100/
    p0001_two_sum/
      Solution.java
      Runner.java

  p0101_0200/
    p0128_longest_consecutive_sequence/
```

Each problem has its own folder containing:

- `Solution.java` — solution written in the same format expected by LeetCode
- `Runner.java` — used for running and debugging the solution locally

---

## Running Problems

Before starting a session:

```
source scripts/aliases.sh
```

Commands:

```
lc 123
```
Run the runner for problem **123**

```
lc 123 open
```
Open the folder for problem **123**

```
lc 123 list
```
Show folders that match problem **123**

---

## Study Workflow

When solving a problem:

1. Review concepts from the notes
2. Attempt the problem without hints
3. Analyze the solution and write notes about the pattern

---

## Notes

- `Notes.md` contains general notes and patterns.
- `phase.txt` contains the roadmap for the topics and problems I plan to study.

---

## Goal

Build strong understanding of algorithms and data structures through consistent practice.