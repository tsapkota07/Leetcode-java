Note: Before the start of your session, type source scripts/aliases.sh to 

<br> Usage: lc [problem_no] . Eg: lc 1
<br> 	 lc 1 open (cd into the folder)
<br> 	 lc 1 list (show matches)

### Use lines such as these to commit for clarity and systematic git history.
>* Add LC 0001 Two Sum
>* Add LC 0142 Linked List Cycle II
>* Refactor LC 0238 to O(1) space

### Step 1 — Concept Review (15 min)
>* Re-read notes
>* Watch short explainations

### Step 2 — (Deep Solve)
>* Write down Input, Output, Preconditions, Postconditions. 
>* Try 30–45 minutes without looking at anything. 
>* Think on paper. Don't hesitate to write down stuff
>* if stuck, take hint only.

### Step 3 — Post-Mortem (Most Important)
In your Notes.md write:
>* Pattern used
>* Why brute force fails
>* Time complexity
>* Space complexity
>* What trick made it work


### For each problem:
>* Solution.java
>* Runner.java
>* Notes.md

***

## Copy paste this: 
```angular2html
pxxxxProblemName

###  Pattern:
### Core Idea:
### Why brute force fails:

### Edge Cases:

### Complexity:
- Time: 
- Space: 

### Mistakes:

### Signal (how to recognize this pattern next time):
```

***

## Solution.java Format: 

```angular2html
package p0001_0100.p0001_two_sum;

class Solution {

    /*
     * LeetCode: 1. Two Sum
     *
     * Pattern:
     *
     * Approach:
     *
     * Time Complexity:
     * Space Complexity:
     */

    public int[] twoSum(int[] nums, int target) {

        // TODO: Implement logic

        return new int[]{};
    }
}
```

*** 
## Runner.java Format:
```angular2html
package p0001_0100.p0001_two_sum;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] result1 = s.twoSum(nums1, target1);

        System.out.println("Test 1: " + Arrays.toString(result1));
        // Expected: [0, 1]

    }
}
```

### Command Line Commands: 
``` 
Build:
    lcbuild

Run:
    lcrun pXXXX_XXXX.pXXXX_problem_name.Runner

Build + Run:
    lcexec pXXXX_XXXX.pXXXX_problem_name.Runner```