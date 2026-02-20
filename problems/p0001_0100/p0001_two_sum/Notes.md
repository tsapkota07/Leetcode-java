Q. Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

-> <br>
We are given an array of integers called "nums" and another integer called "target", which is the value that two 
of our integers in the array "nums" add up to.
<br> We have to assume that each input would have exactly one solution. So, what does this exactly mean? 
<br> If let's say, [0,1,2,3,4] is our array and our target is 4. This will be an invalid input. 
<br> it is given that each input would have exactly one solution. In this case we get two solutions: (0,4) and (1,3)

Basically, this kind of input is something we shouldn't expect. Also, we can't use the same number twice. 
<br> Eg: We cant use 2 plus itself to get our target 4. 
<br> Also keep in mind that, we don't return the actual numbers but the indices of where they are in our array. 
<br>
Now onto the actual question. 

Trying basic brute force, we can check each number against every other number. For eg, we can check 0 against 
1, 2, 3, 4, in the above case (which is a invalid input btw). So we should try a nested for loop that 
checks if the numbers in the current indices equal to the target or not. Each loop will also need to check if 
the current values being looped with equate to our target or not. Meaning, when we check 0 against others in this 
case, if 0 doesn't work, we can check 1 with all other cases. But, we need not check with 0 again as we already did in the previous loop. 

So, i try writing the code now... 

I brute forced it. 

----------------------------------------------
Input: int[] nums, target
Output:  nums[i] + nums[j] = target, retuns [i,j]
Preconditions :
nums is an array of integer. 
The arrays can't have two different pairs that equate to 0. 
target is an integer. 

Postconditions:
return indice i and j such that nums[i] + nums[j] = target. 

