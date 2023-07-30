/*
Valid Palindrome II

PROBLEM STATEMENT
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
*/
//My Code:
class Solution {
    public boolean f(int start, int end, String s, boolean flag){
        if(start>end)
            return true;
        if(s.charAt(start)==s.charAt(end))
            return f(start+1, end-1, s, flag);
        else if(s.charAt(start)!=s.charAt(end) && !flag)
            return (f(start+1, end, s, true) || f(start, end-1, s, true));        
        else
            return false;
    }
    public boolean validPalindrome(String s) {
        return f(0, s.length()-1, s, false);
    }
}
