package p0201_0300.p0242_Valid_Anagram;


import java.util.HashMap;

/*
Given two strings s and t, return true if t is an anagram of s and return false otherwise.
Constraints:
- 1 <= s.length, t.length <= 5 * 104
- s and t consist of lowercase English letters.
 */
public class Solution
{
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        // Store each character and their frequency inside a map of key-> value.
        HashMap<Character, Integer> counterMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            counterMap.put(s.charAt(i) , counterMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // compare against the stored values.
        for (int i = 0; i < t.length(); i++){
            int value = counterMap.getOrDefault(t.charAt(i), 0);
            counterMap.put(t.charAt(i), value - 1);
            if (counterMap.get(t.charAt(i)) < 0){
                return false;
            }
        }

        return true;
    }
}


/*
Pattern: Hashing
Core Idea: Store all the characters and their frequency in one array into a hashmap where characters are key and
    frequency are value.
Why brute force fails: I don't even know what the brute force approach would be. Hashing seems way easier. If I had
    to brute force it, then I would have to compare against each. Probably O(n^3) time even.
Edge Cases: I didn't try comparing the lengths of the arrays at first, and when arrays differed in size, I calculated
    everything like an idiot.

Complexity:
-Time: O(n)
-Space: O(n)

Mistakes: I did i-- while cmparing against sorted values. Kind of stupid on my end.

Signal (how to recognize this pattern next time): Whenever it has to do something about storing frequency of something,
    hashmaps seem to be useful .
*/
