# Edge Cases

What would break your solution? Test it.

## Empty / Single Element

Array []? Array [5]? String ""?

What if there's only one thing? Especially if you're looking for pairs.

## Duplicates

All same [5, 5, 5, 5]? Same at start and end? Does your algorithm handle frequency?

## Negatives

All negative? Mix of positive/negative? Does logic still work?

## Large Numbers

Integer overflow? (max int is 2^31 - 1 in Java)

If you multiply or add, could it exceed range?

## Already Sorted / Reverse

Input [1, 2, 3, 4, 5]? Input [5, 4, 3, 2, 1]?

Does your solution assume unsorted?

## Off-by-One

Loop: `< length` or `<= length`?

Array index: start at 0?

Pointers: moving the right one?

## How to Find Them

After coding, ask: "What input would break this?"

For every loop/variable: "What if it's 0? What if it's 1?"

For operations: "What if inputs are extreme?"

Test boundaries first. Then edge cases.

## Strategy

1. Code it
2. Test with given examples
3. Add one edge case
4. If it fails, fix it
5. Move on

Don't try to handle everything before coding. Code first, then break it.

