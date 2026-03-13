Overview of my setup: 

### Note: Before the start of your session, type source scripts/aliases.sh to use these 

lc 123 -> run the runner for problem number 123. 

lc 123 open -> open the project folder for problem number 123

lc 123 list -> show the folders that match 123 in them. 

### Use lines such as these to commit for clarity and systematic git history.
Add LC 0001 Two Sum

Add LC 0142 Linked List Cycle II

Refactor LC 0238 to O(1) space

### This is how my problems folder is structured: 
I plan to have all leetcode problems solved. I want each problem to be limited to one folder. 
To make it easier on me, I group 100 folder each so on the 2nd layer after problems, I have about 35 folders. 
eg: p_0001_0100 stores leetcode problems number 1 to 100 and so on. 
In each of those folders I store 100 folders as pXXXX_problem_name. 

To run each problem, simply do lc PROBLEM_NUMBER. To go into the particular folder for that problem number do 
lc PROBLEM_NUMBER open.

In each of the problem folder there is a Runner and Solution java file. Solve the solution as if you solve a solution
class in leetcode. Then design the runner (I just ask GPT) so you can actually run the problem inside of an IDE. I could
to fill all problems with at least the Runner for each problem so others can practise, but I won't do it. 

## Study Time
When you get down to solve a problem, follow this:

### Step 1 — Concept Review 
Read/ Re-read notes

Watch short explainations

Basically understand the concept.

### Step 2 — (Deep Solve)
Inside of Solution:

Write down Input, Output, Preconditions, Postconditions.

Try 30 minutes without looking at anything.

Think on paper/the text editor. Don't hesitate to write down stuff

if stuck, take hint only.

### Step 3 — Post-Mortem (Most Important)
After you succesfully get a solution, fill this just under your Solution class:
```angular2html
/*
Pattern:

Core Idea:

Why brute force fails:

Edge Cases:

Complexity:
Time:
Space:

Mistakes:

Signal (how to recognize this pattern next time):

*/
```

## Runner.java Format:
```angular2html
NOTE: This part and below is optional and you don't need to know all that to solve the problems.  
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